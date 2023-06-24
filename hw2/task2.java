package Homework.hw2;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.sound.midi.MidiDevice.Info;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class task2 {
    /*
     * Реализуйте алгоритм сортировки пузырьком числового массива,
     * результат после каждой итерации запишите в лог-файл.
     */

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Logger ll = Logger.getLogger(task2.class.getName());

        String logsPath = "log.txt";
        FileHandler fh = new FileHandler(logsPath, false);
        FileHandler fh1 = new FileHandler(logsPath, true);
        ll.addHandler(fh);
        ll.addHandler(fh1);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        fh1.setFormatter(formatter);

        int[] array = new int[] { 11, 23, 14, 66, 30, 19 };

        System.out.println(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                System.out.println(array);
                ll.log(Level.INFO,"modified array");
            }

        }
                ll.log(Level.INFO,"done");
    }
}
