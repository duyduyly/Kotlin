package com.alan.login.models.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "USER1")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "USERNAME", unique = true)
    lateinit var username: String

    @Column(name = "PASSWORD", length = 2000)
    lateinit var password: String

    @Column(name = "SALT")
    lateinit var salt: String
}