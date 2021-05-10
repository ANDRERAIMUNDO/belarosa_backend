package me.andreraimundo.belarosa_backend.services.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Cliente;

@Service
public class CalcularIdade {
    private int age;
    private Date dateNasc;
    Calendar dateOfBirth = new GregorianCalendar();
    Calendar today = Calendar.getInstance();

    public CalcularIdade () {

    }

    public CalcularIdade (int age, Cliente obj)  {
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
        this.age = age;
        try {
            dateNasc = sdf.parse(obj.getDateNasc());
            } catch (Exception e) 
            {

            }
    }
    public int getAge() {
        age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
        if (today.before(dateOfBirth)) {
        age--;
        }
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getDateNasc() {
        return dateNasc;
    }
    public void setDateNasc(Date dateNasc) {
        this.dateNasc = dateNasc;
    }   
}
