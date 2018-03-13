package com.mercedes.sqlliteexample

/**
 * Created by Mercedes on 13/3/2018.
 */
class User{
    var id: Int = 0
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int){
        this.name = name
        this.age = age
    }
    constructor(){
    }
}