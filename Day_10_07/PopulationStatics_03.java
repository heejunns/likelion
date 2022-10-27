package Day_10_07;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopulationStatics_03 {
    public List<PopulationMove> readByline2(String filename){
        List<PopulationMove> pml = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get(filename), StandardCharsets.UTF_8
        )){
            String line;
            while ((line = br.readLine()) != null){
                // System.out.println(line);
                PopulationMove p = parse(line);
                pml.add(p);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
      return pml;
    }
    public void readByChar(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);

        String fileContents = "";
        while (fileContents.length() < 10_000_00) {
            char c = (char) fileReader.read();
            fileContents += c;

        }
        System.out.println(fileContents);

    }

    public void readline(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
        reader.close();

    }
    public PopulationMove parse(String data){
        String[] splitlines = data.split(",");
        Integer fromSido = Integer.valueOf(splitlines[0]);
        Integer toSido = Integer.valueOf(splitlines[1]);
        return new PopulationMove(fromSido,toSido);
    }
    void createANewFile(String filename) throws IOException{
        File file = new File(filename);
        try{
            file.createNewFile();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
    public void write(List<String> strs, String filename) {
        File file = new File(filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String str : strs) {
                writer.write(str);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String fromToString(PopulationMove populationMove){
        return populationMove.getFromSido()+","+ populationMove.getToSido()+"\n";
    }

    public static void main(String[] args) throws IOException {
        String address = "/Users/jeonghuijun/Downloads/2021_인구관련연간자료_20221007_41144.csv";
        PopulationStatics_03 populationStatics = new PopulationStatics_03();
        List<PopulationMove> pml= populationStatics.readByline2(address);

        List<String> strings = new ArrayList<>();
        Set<Integer> sidoCodes = new HashSet<>();
        for (PopulationMove pm : pml){
            System.out.printf("전입:%s, 전출:%s \n",pm.getFromSido(),pm.getToSido());
            sidoCodes.add(pm.getFromSido()); //
            sidoCodes.add(pm.getToSido()); //
            //String fromTo = populationStatics.fromToString(pm);
            //strings.add(fromTo);
        }
        System.out.println(sidoCodes); // 중복되지 않는 시,도 코드 출력 
        //populationStatics.write(strings, "./from_to.txt");
        //populationStatics.createANewFile("from_to.txt");
        /*for(PopulationMove pm : pml){
            System.out.printf("전입:%s, 전출:%s \n",pm.getFromSido(),pm.getToSido());
        }
        System.out.println(pml.size());

         */


    }
}
