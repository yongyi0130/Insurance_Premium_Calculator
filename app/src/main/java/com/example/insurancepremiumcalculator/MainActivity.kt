package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AmountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(AmountViewModel::class.java)
        var premium = 0

        btnCalculate.setOnClickListener(){
            if(spinner.selectedItemPosition == 0){
                premium = 60
            }
            else if(spinner.selectedItemPosition == 1){
                premium = 70
                if(radioGroup.radMale.isChecked){
                    premium += 50;
                }
                if(chkSmoker.isChecked){
                    premium += 100;
                }
            }
            else if(spinner.selectedItemPosition == 2){
                premium = 90
                if(radioGroup.radMale.isChecked){
                    premium += 100;
                }
                if(chkSmoker.isChecked){
                    premium += 150;
                }
            }
            else if(spinner.selectedItemPosition == 3){
                premium = 120
                if(radioGroup.radMale.isChecked){
                    premium += 150;
                }
                if(chkSmoker.isChecked){
                    premium += 200;
                }
            }
            else if(spinner.selectedItemPosition == 4){
                premium = 150
                if(radioGroup.radMale.isChecked){
                    premium += 200;
                }
                if(chkSmoker.isChecked){
                    premium += 250;
                }
            }
            else if(spinner.selectedItemPosition == 5){
                premium = 150
                if(radioGroup.radMale.isChecked){
                    premium += 200;
                }
                if(chkSmoker.isChecked){
                    premium += 300;
                }
            }
            viewModel.payment = premium

            lblAmount.text = viewModel.payment.toString()
        }

        btnReset.setOnClickListener(){
            spinner.setSelection(0)
            radioGroup.clearCheck()
            chkSmoker.isChecked = false
            lblAmount.text = ""
            viewModel.payment = 0
        }
    }
}
