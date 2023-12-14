package Homework.hw6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class shop implements Cloneable {
    List<Notebook> notebookArrayList;

    public shop(){
        this.notebookArrayList = new ArrayList<>();
    }

    static class Notebook{
        String brandname;
        int screenSizeInch;
        int displayRate;
        String processor;
        int ramVolume;
        String videocard;
        Integer hddVolume;
        String os;
        String color;

        public Notebook(String brandname, int screenSizeInch, int displayRate, String processor, int ramVolume,
                        String videocard, Integer hddVolume, String os, String color) {
            this.brandname = brandname;
            this.screenSizeInch = screenSizeInch;
            this.displayRate = displayRate;
            this.processor = processor;
            this.ramVolume = ramVolume;
            this.videocard = videocard;
            this.hddVolume = hddVolume;
            this.os = os;
            this.color = color;
        }

        public Notebook(String brandname){
            this.brandname = brandname;
        }

        public Notebook(){
        }

        @Override
        public String toString() {
            return ""+brandname+" "+screenSizeInch+" "+displayRate+" "+processor+" "+ramVolume+" "
                    +videocard+" "+hddVolume+" "+os+" "+color+"";
        }

    }


    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        try {
            for (Notebook notebook : notebookArrayList) {
                line.append(notebook+"\n");
            }
        } catch (Exception e) {
            return "Перечень ноутбуков пуст";
        }
        return line.toString();
    }

    public void printMarkdownTable() {
        String title = "\nbrandname|screenSizeInch|displayRate|processor|ramVolume|videocard|hddVolume|os|color\n";
        String row = "";
        System.out.println(title);

        for (Notebook notebook : this.notebookArrayList) {
            row = notebook.toString().replaceAll(" ", "|");
            System.out.println(row);
        }
    }

    public Notebook get(int index) {
        return this.notebookArrayList.get(index);
    }

    public Integer getIndex(Notebook notebook) {
        int index = -1;
        for (Notebook notebookFromArr : this.notebookArrayList) {
            index++;
            if (notebook.equals(notebookFromArr)) {
                break;
            }
        }
        return index;
    }

    public Shop set(Notebook notebook) {
        this.notebookArrayList.add(notebook);
        return this;
    }

    public List<Notebook> insertRandom(int quantity) {
        Notebook[] notebooksRnd = new Notebook[quantity];
        this.notebookArrayList = Arrays.asList(notebooksRnd);
        Random rnd = new Random();

        String[] brands = new String[] {"Apple", "Acer", "ASUS", "HUAWEI", "Lenovo", "Microsoft", "Xiaomi",
                "GIGABYTE", "MSI", "Samsung"};
        Integer[] screenSize = new Integer[] {10, 11, 12, 13, 14, 15, 16, 17, 18};
        Integer[] displayRate = new Integer[] {50, 60, 100, 120, 144, 240};
        String[] processor = new String[] {"Apple", "Intel", "AMD"};
        Integer[] ramVolume = new Integer[] {4, 8, 16, 32, 64, 128, 256};
        String[] videocard = new String[] {"Intel", "AMD", "NVIDIA"};
        Integer[] hddVolume = new Integer[] {1, 2, 4, 8, 16, 32};
        String[] os = new String[] {"MacOS", "Linux", "Windows", "DOS", "None"};
        String[] color = new String[] {"Red", "Yellow", "Green", "Blue", "Black", "White", "Silver", "Gold", "Grey"};

        for (int i = 0; i < quantity; i++) {
            notebooksRnd[i] = new Notebook(brands[rnd.nextInt(brands.length)],
                    screenSize[rnd.nextInt(screenSize.length)], displayRate[rnd.nextInt(displayRate.length)],
                    processor[rnd.nextInt(processor.length)], ramVolume[rnd.nextInt(ramVolume.length)],
                    videocard[rnd.nextInt(videocard.length)], hddVolume[rnd.nextInt(hddVolume.length)],
                    os[rnd.nextInt(os.length)], color[rnd.nextInt(color.length)]);
        }

        return this.notebookArrayList;
    }

    private List<Notebook> filterNotebooks(int filter) {
        List<Notebook> filtered = new ArrayList<>();
        Scanner inputData = new Scanner(System.in);
        if (filter == 1 || filter == 4 || filter == 6 || filter == 8 || filter == 9) {
            String searchingPart = "";
            System.out.printf("Какой критерий? - ");
            String search = inputData.nextLine();
            for (Notebook notebook : this.notebookArrayList) {
                searchingPart = notebook.toString().split(" ")[filter-1].trim();
                if (searchingPart.equalsIgnoreCase(search)) {
                    filtered.add(notebook);
                }
            }
        } else {
            System.out.printf("От какого значения - ");
            int searchFrom = inputData.nextInt();
            System.out.printf("До какого значения - ");
            int searchTill = inputData.nextInt();
            int searchingPart = -1;
            for (Notebook notebook : this.notebookArrayList) {
                searchingPart = Integer.parseInt(notebook.toString().split(" ")[filter-1].trim());
                if (searchingPart >= searchFrom && searchingPart <= searchTill) {
                    filtered.add(notebook);
                }
            }
        }
        return filtered;
    }

    public List<Notebook> filter() {
        // 1 brands
        // 2 screenSize
        // 3 displayRate
        // 4 processor
        // 5 ramVolume
        // 6 videocard
        // 7 hddVolume
        // 8 os
        // 9 color

        Shop filtered = new Shop();
        Scanner inputData = new Scanner(System.in);
        Message( "1. Бренд\n"+//
                "2. Диагональ экрана\n"+//
                "3. Частота Hz экрана\n"+//
                "4. Процессор\n"+//
                "5. Объем ОЗУ\n"+//
                "6. Видеокарта\n"+//
                "7. Объем HDD / SDD\n"+//
                "8. Операционная система\n"+//
                "9. Цвет");
        System.out.printf("Выберите категорию поиска: ");
        int filter = -1;
        try {
            filter = inputData.nextInt();
        } catch (Exception e) {
            System.out.println("Исключение");
        }
        if (1 <= filter && filter <= 9) {
            filtered.notebookArrayList = this.filterNotebooks(filter);
        } else {
            Message("Ошибка ввода!");
        }

        return filtered.notebookArrayList;
    }

    private static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    private static void Message(String text) {
        System.out.println(text);
    }

}
