package com.example.fragment_que_second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fone  = Frag_first()
        val ftwo  = Frag_second()


        btn_add.setOnClickListener {

            if(!fone.isAdded){
                supportFragmentManager.beginTransaction().add(R.id.container,fone).commit()
            }
            else
            {
                Toast.makeText(this,"Fragment  One already added",Toast.LENGTH_SHORT).show();
            }
        }
        btn_replace.setOnClickListener {


            if(fone.isAdded){
                supportFragmentManager.beginTransaction().replace(R.id.container,ftwo).commit()
            }else if(ftwo.isAdded)
            {
                supportFragmentManager.beginTransaction().replace(R.id.container,fone).commit()
            }else
            {

                Toast.makeText(this,"Please add a fragment first",Toast.LENGTH_SHORT).show()
            }

        }

        btn_hide.setOnClickListener {

            if(fone.isAdded)
            {
                supportFragmentManager.beginTransaction().hide(fone).commit()
            }
            else if(ftwo.isAdded)
            {
                    supportFragmentManager.beginTransaction().hide(ftwo).commit()
            }
            else{
                Toast.makeText(this,"Nothing to hide please add first",Toast.LENGTH_LONG).show()
            }



            }
            btn_show.setOnClickListener {


                if(fone.isHidden)
                {
                    supportFragmentManager.beginTransaction().show(fone).commit()
                }
                else if(ftwo.isHidden)
                {
                    supportFragmentManager.beginTransaction().show(ftwo).commit()
                }
                else{
                    Toast.makeText(this,"Nothing to hide please add first",Toast.LENGTH_LONG).show()
                }
            }



        btn_remove.setOnClickListener {

            if(fone.isAdded)
            {
                supportFragmentManager.beginTransaction().remove(fone).commit()
            }
            else if(ftwo.isAdded)
            {
                supportFragmentManager.beginTransaction().remove(ftwo).commit()

            }
            else
            {
                Toast.makeText(this,"Nothing added container empty",Toast.LENGTH_SHORT).show()
            }

            }


        }

    }

