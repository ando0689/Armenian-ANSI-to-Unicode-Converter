package am.andranik;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArmToUnicodeMap {

    public static Map<Integer, Integer> getMap(){
        final Map<Integer, Integer> m = new HashMap<>();

        m.put(178, 1329);
        m.put(179, 1377);
        m.put(180, 1330);
        m.put(181, 1378);
        m.put(182, 1331);
        m.put(183, 1379);
        m.put(184, 1332);
        m.put(185, 1380);
        m.put(186, 1333);
        m.put(187, 1381);
        m.put(188, 1334);
        m.put(189, 1382);
        m.put(190, 1335);
        m.put(191, 1383);
        m.put(192, 1336);
        m.put(193, 1384);
        m.put(194, 1337);
        m.put(195, 1385);
        m.put(196, 1338);
        m.put(197, 1386);
        m.put(198, 1339);
        m.put(199, 1387);
        m.put(200, 1340);
        m.put(201, 1388);
        m.put(202, 1341);
        m.put(203, 1389);
        m.put(204, 1342);
        m.put(205, 1390);
        m.put(206, 1343);
        m.put(207, 1391);
        m.put(208, 1344);
        m.put(209, 1392);
        m.put(210, 1345);
        m.put(211, 1393);
        m.put(212, 1346);
        m.put(213, 1394);
        m.put(214, 1347);
        m.put(215, 1395);
        m.put(216, 1348);
        m.put(217, 1396);
        m.put(218, 1349);
        m.put(219, 1397);
        m.put(220, 1350);
        m.put(221, 1398);
        m.put(222, 1351);
        m.put(223, 1399);
        m.put(224, 1352);
        m.put(225, 1400);
        m.put(226, 1353);
        m.put(227, 1401);
        m.put(228, 1354);
        m.put(229, 1402);
        m.put(230, 1355);
        m.put(231, 1403);
        m.put(232, 1356);
        m.put(233, 1404);
        m.put(234, 1357);
        m.put(235, 1405);
        m.put(236, 1358);
        m.put(237, 1406);
        m.put(238, 1359);
        m.put(239, 1407);
        m.put(240, 1360);
        m.put(241, 1408);
        m.put(242, 1361);
        m.put(243, 1409);
        m.put(244, 1362);
        m.put(245, 1410);
        m.put(246, 1363);
        m.put(247, 1411);
        m.put(248, 1364);
        m.put(249, 1412);
        m.put(250, 1365);
        m.put(251, 1413);
        m.put(252, 1366);
        m.put(253, 1414);
        m.put(168, 1415);
        m.put(8226, 1379);
        m.put(39, 1370);
        m.put(176, 1371);
        m.put(175, 1372);
        m.put(170, 1373);
        m.put(177, 1374);
        m.put(163, 1417);
        m.put(173, 1418);
        m.put(167, 171);
        m.put(166, 187);
        m.put(171, 44);
        m.put(169, 46);
        m.put(174, 8230);

        return m;
    }


    public static Map<Integer, Integer> getMapFromFile() throws IOException {
        Map<Integer, Integer> m = new HashMap<>();

        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        File file = new File("src/table.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("<input type=")) {
                    int numeric = Integer.parseInt(line.replaceAll("\\D+",""));

                    if(count % 2 == 0){
                        keys.add(numeric);
                    } else {
                        values.add(numeric);
                    }

                    count++;
                }
            }
        }

        if(keys.size() != values.size()){
            System.out.println("OPPS " + keys.size() + "  " + values.size());
        }

        for(int i = 0; i < keys.size(); i++){
            m.put(keys.get(i), values.get(i));
            System.out.println(String.format("m.put(%s, %s);", keys.get(i), values.get(i)));
        }

        return m;
    }


}
