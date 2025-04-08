package com.alan.login.config

import com.alan.login.models.entity.User
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenProvider {

    var logger: Logger = LoggerFactory.getLogger(JwtTokenProvider::class.java)

    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private val JWT_SECRET = "lodaaaaaa"

    //Thời gian có hiệu lực của chuỗi jwt
    private val JWT_EXPIRATION = 604800000L

    // Tạo ra jwt từ thông tin user
    fun generateToken(user: User): String {
        val now: Date = Date()
        val expiryDate: Date = Date(now.getTime() + JWT_EXPIRATION)
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
            .setSubject(user.id.toString())
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
            .compact()
    }

    // Lấy thông tin user từ jwt
    fun getUserIdFromJWT(token: String?): Long {
        val claims = Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .body

        return claims.subject.toLong()
    }

    fun validateToken(authToken: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken)
            return true
        } catch (ex: MalformedJwtException) {
            logger.error("Invalid JWT token")
        } catch (ex: ExpiredJwtException) {
            logger.error("Expired JWT token")
        } catch (ex: UnsupportedJwtException) {
            logger.error("Unsupported JWT token")
        } catch (ex: IllegalArgumentException) {
            logger.error("JWT claims string is empty.")
        }
        return false
    }
}