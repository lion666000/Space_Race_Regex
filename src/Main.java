void main() {


    Path path = Path.of("src/trenink_piloti_testovaci_data.txt");
    List<Pilot> piloti = new ArrayList<>();

    try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
        String radek;
        while ((radek = bufferedReader.readLine()) != null) {
            if (radek.isBlank()) {
                continue;
            }
            Pilot pilot = new Validation((radek)).validation();
            if (pilot != null) {
                piloti.add(pilot);
            }
        }
    }
    catch(IOException e){
        System.err.println("Chyba pri praci se souborem.");
    }

    System.out.println();
    System.out.println("=== Platně zadaní vězni (příjmení, rok narození) ===");
    for (Pilot pilot : piloti) {
        System.out.println(pilot.toString());

    }
    System.out.println("Celkem platných záznamů: " + piloti.size());


    int mostWins = 0;
    int youngest = 0;
    System.out.println("Starší 50 let");
    for  (Pilot pilot : piloti) {
        if (pilot.getRokNarozeni() >= 1976){
            System.out.println(pilot.toString());
        }
        if (pilot.getRokNarozeni() > youngest){
            youngest = pilot.getRokNarozeni();
        }
        if  (pilot.getPocetVytezstvi() > mostWins) {
            mostWins = pilot.getPocetVytezstvi();
        }
    }

    System.out.println("Nejmadší: " + youngest);

    System.out.println("Nejvíce vítězství: ");
    for (Pilot pilot : piloti) {
        if (pilot.getPocetVytezstvi() == mostWins) {
            System.out.println(pilot.toString());
        }
    }


}
