package app2;

//import app2.service.Service;
import app2.record.companiesRecord;
import app2.record.companiesRecord;
import app2.record.usersRecord;
import app2.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<companiesRecord> companyList;
        List<usersRecord> userList;

        // メニュー管理システムを表示
        System.out.println("------------------------------");
        System.out.println("ユーザー管理システム\n");
        System.out.println("メニュー管理システム");
        System.out.println("1:一覧表示");
        System.out.println("2:新規作成");
        System.out.println("3:削除");
        System.out.println("9:終了");

        var service = new Service();
        // fildAll() メソッドを最初に呼び出して companyList を初期化する
        service.fildAll();

        while (true) {
            var sc = new Scanner(System.in);
            var input = sc.nextInt();

            if (input == 1) {
            // 1の処理　ユーザー一覧表示
                var userService = new Service();
                userList = userService.fildAll();
                userList.stream().forEach(System.out::println);
                System.out.println("");
                System.out.println("メニュー管理システム");
                System.out.println("1:一覧表示");
                System.out.println("2:新規作成");
                System.out.println("3:削除");
                System.out.println("9:終了");

            } else if (input == 2) {
            // ２の処理　ユーザーを追加　インサート
                System.out.println("------------------------------");
                System.out.println("ユーザー追加");
                System.out.println("所属企業を選択してください。");


                // 会社情報初期化
                companyList = new ArrayList<>();
                companyList.add(new companiesRecord(1, "株式会社A"));
                companyList.add(new companiesRecord(2, "株式会社B"));

                for(var company : companyList) {
                    System.out.println(company.id() + "：" + company.name());
                }

                sc = new Scanner(System.in);
                var company_id = sc.nextInt();

                System.out.println("");
                System.out.println("名前を入力してください。");

                var sc2 = new Scanner(System.in);
                var name2 = sc2.nextLine();

                System.out.println("");
                System.out.println("スコアを入力してください。");

                var score = sc.nextInt();

                var newusers = new usersRecord(0,  company_id, name2,score);
                Service.insert(newusers);

                System.out.println("以下の内容でユーザーが追加されました。");
                System.out.println("id：" + newusers.id());
                System.out.println("所属企業ID：" + newusers.company_id());
                System.out.println("名前：" + newusers.name());
                System.out.println("スコア：" + newusers.score());

                System.out.println("");
                System.out.println("メニュー管理システム");
                System.out.println("1:一覧表示");
                System.out.println("2:新規作成");
                System.out.println("3:削除");
                System.out.println("9:終了");

            } else if (input == 3) {
                System.out.println("------------------------------");
                System.out.println("ユーザー削除");
                System.out.println("削除するユーザーのIDを入力してください。");

                var userService = new Service();
                userList = userService.fildAll();

                sc = new Scanner(System.in);
                var id = sc.nextInt();

                var targetUser = userList.stream().filter(user -> user.id() == id).findFirst().get();
                Service.delete(targetUser);

                System.out.println("以下のユーザーを削除しました。");
                System.out.println("id：" + targetUser.id());
                System.out.println("所属企業id：" + targetUser.company_id());
                System.out.println("名前：" + targetUser.name());
                System.out.println("スコア：" + targetUser.score());

                System.out.println("");
                System.out.println("メニュー管理システム");
                System.out.println("1:一覧表示");
                System.out.println("2:新規作成");
                System.out.println("3:削除");
                System.out.println("9:終了");


            } else if (input == 9) {
                // 9の処理　プログラム終了
                System.out.println("終了します。");
                break;
            }else {
            // 入力数値が不適切な場合の処理
                System.out.println("もう一度入力してください。");
            }
        }
    }
}
