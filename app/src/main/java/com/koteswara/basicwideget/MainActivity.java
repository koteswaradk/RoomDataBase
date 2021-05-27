package com.koteswara.basicwideget;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.koteswara.basicwideget.databinding.SignupformBinding;
import com.koteswara.basicwideget.room.PersonalDetailsDataBase;
import com.koteswara.basicwideget.room.PersonalDetailsModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SignupformBinding binding;
    String gender;
    PersonalDetailsDataBase   dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupformBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void submitForm(View view) {
        isEmpty(binding);
    }

    public void radioButtonhandler(View view){
        if (binding.male.isChecked()){
            gender="male";
        }if (binding.female.isChecked()){
            gender="female";
        }
    }
    private void isEmpty(SignupformBinding viewbinding) {

        if (viewbinding.FirstName.getText().toString().isEmpty()) {
            viewbinding.FirstName.setError(viewbinding.FirstName.getHint());
        }if (viewbinding.LastName.getText().toString().isEmpty()) {
            viewbinding.LastName.setError(viewbinding.LastName.getHint());
        }if (viewbinding.age.getText().toString().isEmpty()) {
            viewbinding.age.setError(viewbinding.age.getHint());
        }if (viewbinding.phonenumber.getText().toString().isEmpty()) {
            viewbinding.phonenumber.setError(viewbinding.phonenumber.getHint());
        }if (viewbinding.address.getText().toString().isEmpty()) {
            viewbinding.address.setError(viewbinding.address.getHint());
        }if (viewbinding.emailid.getText().toString().isEmpty()) {
            viewbinding.emailid.setError(viewbinding.emailid.getHint());
        }if (viewbinding.dateOfBirth.getText().toString().isEmpty()) {
            viewbinding.dateOfBirth.setError(viewbinding.dateOfBirth.getHint());
        }if (viewbinding.password.getText().toString().isEmpty()) {
            viewbinding.password.setError(viewbinding.password.getHint());
        }if (viewbinding.genderGroup.getCheckedRadioButtonId()== -1){
            viewbinding.radioGroupName.setError(viewbinding.radioGroupName.getText());
        }else{
            insertdata(viewbinding);
            ReadData();
        }


    }
public void insertdata(SignupformBinding viewbinding){
    class InsertData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
               dataBase = PersonalDetailsDataBase.getdatabase(getApplicationContext());
            PersonalDetailsModel  personaldetails=
                    new PersonalDetailsModel(viewbinding.FirstName.getText().toString(),
                            viewbinding.LastName.getText().toString(),
                            gender, viewbinding.age.getText().toString(),
                            viewbinding.phonenumber.getText().toString(),
                            viewbinding.address.getText().toString(),
                            viewbinding.emailid.getText().toString(),
                            viewbinding.dateOfBirth.getText().toString(),
                            viewbinding.password.getText().toString());
            dataBase.personalDetailsDAO().insertPersonalDetails(personaldetails);



            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"executing",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(MainActivity.this,"completed",Toast.LENGTH_SHORT).show();



        }
    }
    InsertData insertData=new InsertData();
    insertData.execute();
}
public void ReadData(){
    class viewdataAsynchtasks extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            List<PersonalDetailsModel> listdata=dataBase.personalDetailsDAO().getPersonalDetails();
            for (int i = 0; i < listdata.size(); i++) {
                listdata.get(i).getFirstName();
                listdata.get(i).getLastName();
                listdata.get(i).getGender();
                listdata.get(i).getAge();
                Log.i("test",listdata.get(0).getFirstName()+" "+ listdata.get(i).getLastName()+" "+ listdata.get(i).getGender()
                +" "+listdata.get(i).getAge());

            }

            return null;
        }
    }
    viewdataAsynchtasks insertData=new viewdataAsynchtasks();
    insertData.execute();
}
    public  void updateData(SignupformBinding binding){
        class updateAsynchTasks extends AsyncTask<Void,Void,Void>{

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }
        updateAsynchTasks insertData=new updateAsynchTasks();
        insertData.execute();
    }
    public  void DeleteData(SignupformBinding binding){
        class deleteAsynchTasks extends AsyncTask<Void,Void,Void>{

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }
        deleteAsynchTasks insertData=new deleteAsynchTasks();
        insertData.execute();
    }

}