package com.mercedes.sqlliteexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = DataBaseHandler(this)

        btnInsert.setOnClickListener({
            if(etvName.text.toString().length > 0 &&
                    etvAge.text.toString().length > 0){
                var user = User(etvName.text.toString(),etvAge.text.toString().toInt())

                db.insertData(user)
            }else{
                Toast.makeText(this,"Missing Data",Toast.LENGTH_SHORT).show()
            }
        })

        btnRead.setOnClickListener({
            var data = db.readData()
            tvResult.text = ""
            for(i in 0..(data.size-1)){
                tvResult.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).age + "\n")
            }
        })

        btnUpdate.setOnClickListener({
            db.updateData()
            btnRead.performClick()
        })

        btnDelete.setOnClickListener({
            db.deleteData()
            btnRead.performClick()
        })
    }
}
