package tiatt.jw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import soup.neumorphism.NeumorphButton;


public class QuizFragment extends Fragment {

    public static QuizFragment newInstance() {
        return new QuizFragment();
    }


    TextView txtQuiz;
//    Button bogie1;
//    Button bogie2;
//    Button bogie3;
//    Button bogie4;

    NeumorphButton bogie1, bogie2, bogie3, bogie4;




    int QuestionNum = 50;
    int CurrentNum = (int)(Math.random()*QuestionNum);
    int AnswerNum;
    String CurrentAnswer;







    String[] QuizArr[] = {
            /*0*/{"2", "<하늬바람>의 뜻으로 알맞은 것은?", "동쪽에서 부는 바람", "서쪽에서 부는 바람", "남쪽에서 부는 바람", "북쪽에서 부는 바람", "<하늬바람>은 서쪽에서 부는 바람을 뜻합니다."},
            /*1*/{"2", "다음 중 <가을>과 관련된 순우리말은?", "꿀비", "떡비", "술비", "도둑비", "<떡비>는 '가을에 추수가 끝나서 떡을 해 먹으면서 쉴 수 있다는 뜻입니다."},
            /*2*/{"1", "<모르는 사이에 조금씩 조금씩>이라는 뜻을 가진 단어는?", "시나브로", "강다짐 ", "보늬", "베쓱", "<시나브로>는 모르는 사이에 조금씩이라는 뜻을 가진 단어입니다."},
            /*3*/{"3", "<잠이 오지 않아 몸을 뒤척거리다>라는 뜻을 가진 단어는?", "가랑거리다", "말똥거리다", "궁싯거리다", "베쓱거리다", "<궁싯거리다>는 잠이 오지 않아 뒤척거리는 것을 말합니다."},
            /*4*/{"2", "<어안>의 뜻으로 알맞은 것은?", "임금의 얼굴과 같이 고귀한 사람의 얼굴을 높여 부르는 말", "어이없어 말을 하지 못하는 혀 안", "어이없어 말을 하지 못하는 모습", "물고기의 눈", "<어안>은 어이없어 말을 못하고 있는 혀 안 이라는 뜻입니다."},
            /*5*/{"2", "<물체의 삐죽하게 내민 부분>이라는 뜻을 가진 단어는?", "멀떠구니", "뿌다구니", "치룽구니", "이정구니", "<뿌다구니>는 물체의 삐죽하게 내민 부분을 뜻합니다."},
            /*6*/{"3", "<귀재다>의 뜻으로 알맞은 것은?", "다른 사람의 말과 자신의 말을 비교하다", "옳고 그름을 분명히 하다", "잘못 들은 것이 아닌가 하고 귀를 기울이다", "의견이 서로 빗나가서 틀어지다", "<귀재다>는 잘못 들은 것이 아닌가 하고 귀를 기울이는 것을 뜻합니다."},
            /*7*/{"1", "<우물지다>의 뜻으로 알맞은 것은?", "뺨에 보조개가 생기다", "미간에 옅은 주름이 잡히다", "얼굴빛이 생기를 찾다", "눈동자에 눈물이 고이다", "<우물지다>는 뺨에 보조개가 생기는 것을 말합니다."},
            /*8*/{"1", "<하는 짓이 점잖고 무게가 있다>라는 뜻을 가진 단어는?", "거방지다", "가탈지다", "우거지다", "둔덕지다", "<거방지다>는 하는 짓이 점잖고 무게가 있다는 뜻입니다." },
            /*9*/{"3", "<지나치게 많이 먹다>의 뜻으로 알맞은 것은?", "얼러먹다", "짓먹다", "질러먹다", "늣먹다", "<짓먹다>는 지나치게 많이 먹는 것을 뜻합니다."},
            /*10*/{"4", "<대수롭지 아니하게 여겨 건성으로 하는 대답>이라는 뜻을 가진 단어는? ", "군대답", "맞대답", "엄대답", "코대답", "<코대답>은 대수롭지 아니하게 여겨 건성으로 하는 대답을 뜻합니다."},
            /*11*/{"2", "<골라내거나 잘라 내고 남은 나머지>이라는 뜻을 가진 단어는?", "꿈지러기", "지스러기", "끄트러기", "무드러기", "<지스러기>는 골라내거나 잘라 내고 남은 나머지를 뜻합니다."},
            /*12*/{"3", "<더펄이>의 뜻으로 알맞은 것은?", "촐랑거리며 조심성 없이 함부로 행동하는 사람 ", "말이나 행동이 얌전하지 못하고 덜렁거리는 여자", "성미가 침착하지 못하고 덜렁대는 사람", "직업이 없이 빌빌거리며 노는 사내", "<더펄이>는 성미가 침착하지 못하고 덜렁대는 사람을 뜻합니다."},
            /*13*/{"1", "<갈피를 잡을 수 없도록 마구 지껄이는 모양>이라는 뜻을 가진 단어는?", "콩팔칠팔 ", "홀랑이질 ", "소바리짐 ", "육두문자", "<콩팔칠팔>은 갈피를 잡을수 없도록 마구 지껄이는 모양이라는 뜻을 가집니다."},
            /*14*/{"1", "<경계선을 따라 좁고 길게 만든 꽃밭>이라는 뜻을 가진 단어는?", "살피꽃밭", "모둠꽃밭", "올림꽃밭", "내림꽃밭", "<살피꽅밭>은 경계선을 따라 좁고 길게 만든 꽃밭을 뜻합니다."},
            /*15*/{"1", "<단출내기>의 뜻으로 알맞은 것은?", "식구가 없어 홀가분한 사람", "만만하게 여길 만큼 평범한 사람", "하찮은 공로나 출세로 거들먹거리는 사람", "어떤 일에 처음 나서서 일이 서투른 사람", "<단출내기>는 식구가 없어 홀가분한 사람을 뜻합니다."},
            /*16*/{"4", "<된바람>의 뜻으로 알맞은 것은?", "동쪽에서 부는 바람", "서쪽에서 부는 바람", "남쪽에서 부는 바람", "북쪽에서 부는 바람", "<된바람>은 북쪽에서 부는 바람을 뜻합니다."},
            /*17*/{"2", "<두 대상이나 물체 사이가 조금 가깝다>의 뜻으로 알맞은 것은?", "검특하다", "바특하다", "사특하다", "특특하다", "<바특하다>는 두 대상이나 물체 사이가 조금 가깝다는 뜻입니다."},
            /*18*/{"4", "<설먹다>의 뜻으로 알맞은 것은?", "덜 익은 음식을 미리 먹다", "보살피는 사람이 없이 제멋대로 자라다", "못나고도 마음이 올바르지 못하다", "넉넉하게 제대로 먹지 못하다", "<설먹다>는 넉넉하게 제대로 먹지 못하다는 뜻입니다."},
            /*19*/{"2", "<성질이 보기보다 상냥하고 부드럽다>는 뜻을 가진 단어는? ", "잗달갑다 ", "곰살갑다", "예질갑다", "갑실갑다", "<곱살갑다>는 성질이 보기보다 상냥하고 부드럽다는 뜻을 가진 단어입니다."},
            /*20*/{"4", "<안다니>의 뜻으로 알맞은 것은?", "어떤 일이나 사상에서 다른 사람보다 앞선 사람", "미련하거나 행동이 느린 사람", "지주를 대리하여 소작권을 관리하는 사람", "무엇이든지 잘 아는 체하는 사람", "<안다니>는 무엇이든지 잘 아는 체하는 사람을 뜻하는 단어입니다."},
            /*21*/{"2", "<반둥건둥>의 뜻으로 알맞은 것은?", "자꾸 게으름을 피우며 놀기만 하는 모양", "중도에서 성의 없이 그만두는 모양", "남의 말을 잘 듣지 아니하고 엇나가는 모양", "일을 건성으로 하는 것 같지만 제대로 하고 있는 모양", "<반둥건둥>은 중도에서 성의 없이 그만두는 모양을 뜻합니다."},
            /*22*/{"4", "<힘 따위를 내세워 젠체하고 억지를 씀>이라는 뜻을 가진 단어는?", "개세", "허세", "차세", "떠세", "<떠세>는 힘 따위를 내세워 젠체하고 억지를 쓴다는 뜻을 가진 단어입니다."},
            /*23*/{"3", "<조금도 틀림이 없다>라는 뜻을 가진 단어는?", "가엾다", "낯없다", "얼없다", "위없다", "<얼없다>는 조금도 틀림이 없다는 뜻입니다."},
            /*24*/{"3", "<깨었다가 다시 든 잠>이라는 뜻을 가진 단어는?", "노루잠 ", "꾸벅잠", "그루잠", "도둑잠", "<그루잠>은 깨었다가 다시 든 잠을 뜻합니다."},
            /*25*/{"1", "<검불덤불>의 뜻으로 알맞은 것은?", "검은빛을 띠면서 조금 붉게", "군데군데 불그스름한 모양", "한데 뒤섞이고 엉클어져 어수선한 모양", "풀과 나무가 무성하게 엉클어진 덤불", ""},
            /*26*/{"2", "<정원 한옆에 둥글거나 모지게 만든 꽃밭>이라는 뜻을 가진 단어는?", "살피꽃밭", "내림꽃밭", "올림꽃밭", "모둠꽃밭", "<모둠꽃밭>은 정원 한옆에 둥글거나 모지게 만든 꽃밭을 뜻합니다."},
            /*27*/{"4", "<꼿꼿이 앉은 채로 자는 잠>이라는 뜻을 가진 단어는?", "귀잠", "발편잠", "벼룩잠", "말뚝잠", "<말뚝잠>은 꼿꼿이 앉은 채로 자는 잠을 뜻합니다."},
            /*28*/{"4", "<자꾸 주춤거리는 모양>이라는 뜻을 가진 단어는?", "조촘조촘", "주촘주촘", "얼낌덜낌", "얼쯤얼쯤", "<얼쯤얼쯤>은 자꾸 주춤거리는 모양을 뜻합니다."},
            /*29*/{"1", "<투레질>의 뜻으로 알맞은 것은?", "젖먹이가 두 입술을 떨며 투루루 소리를 내는 짓", "갓난아이가 자면서 웃거나 눈, 입 따위를 쫑긋거리는 짓", "어린아이가 잠잘 때나 깨었을 때 떼를 쓰며 우는 짓", "젖먹이가 두 손을 쥐었다 폈다 하는 동작", "<투레질>은 젖먹이가 두 입술을 떨며 투루루 소리를 내는 것을 말합니다."},
            /*30*/{"4", "<댓두러기>는?", "어린 비둘기", "늙은 비둘기", "어린 매", "늙은 매", "<댓두러기>는 늙은 매를 뜻합니다."},
            /*31*/{"2", "<개불탕>은 _____를 그린 그림이라는 뜻입니다. _____은 무엇인가요?", "석가모니", "부처", "개불을 넣은 탕", "개와 불타는 탕", "<개불탕>은 부처를 그린 그림을 뜻합니다."},
            /*32*/{"4", "다음 중 <단내>의 뜻으로 옳지 않은 것은?", "높은 열이나 불에 눌어서 나는 냄새", "달콤한 냄새", "몸의 열이 높을 때 입이나 코 안에서 나는 냄새", "특정 화학 물질을 다룰 때 나는 냄새", "<특정 화학 물질을 다룰 때 나는 냄새>는 <단내>의 뜻이 아닙니다."},
            /*33*/{"4", "다음 중 순우리말이 아닌 것은?", "류거홀", "림배", "리어", "자장면", "자장면 : 炸醬麵"},
            /*34*/{"3", "다음 중 서로 반대되는 바람을 뜻하는 것은?(예 : 북풍 - 남풍)", "샛바람 - 막새바람", "마칼바람 - 높새바람", "하늬바람 - 샛바람", "막새바람 - 마칼바람", "<하늬바람>은 서풍, <샛바람>은 동풍을 뜻합니다."},
            /*35*/{"2", "2019년의 안해(年)는?", "2017", "2018", "2020", "2021", "<안해>는 바로 전 해를 뜻하는 말입니다."},
            /*36*/{"1", "<씽씽이>의 뜻으로 알맞은 것은?", "하모니카", "트럼펫", "리코더", "멜로디언", "<씽씽이>(순우리말)의 뜻은 하모니카입니다."},
            /*37*///{"1", "선린인터넷고등학교에서 볼 수 없는 것은?", "찌러기", "주름보", "주럼", "츠렁바위", "<찌러기>는 매우 사나운 소를 뜻합니다."},
            /*38*/{"1", "오늘은 2019년 12월 1일이다. <후제>는?", "2019년 12월 2일", "2020년 12월 1일", "2019년 12월 8일", "2019년 12월 31일", "<후제>는 내일을 뜻하는 순우리말입니다."},
            /*39*/{"3", "다음 중 물(H20)과 관련된 단어가 아닌 것은?", "미세기", "몰개", "미리내", "물꽃", "<미리내>는 은하수라는 뜻으로, 물(H2O)과는 관련 없습니다."},
            /*40*/{"3", "<뜨악하다>의 뜻으로 옳지 않은 것은?", "마음이 선뜻 내키지 않아 꺼림칙하고 싫다.", "마음이가 분위기가 맞지 않아 서먹하다.", "오랜 벗과 이별하다", "사귀는 사이가 떠서 서먹하다.", "<뜨악하다>는 서로 맞지 않다는 정도로 쓰이며, 오랜 벗과 이별하는 것은 맞지 않습니다."},
            /*41*/{"4", "다음 중 비(雨)와 관련이 있는 단어는?", "비두로기", "비역", "비접", "비칼", "<비칼>은 비가 어떤 물건을 깎는 구실을 한다는 뜻입니다."},
            /*42*/{"4", "다음 중 <석얼음>의 뜻으로 옳지 않은 것은?", "수정 속에 보이는 잔술", "유리창 위에 있는 얼음", "유리창 아래에 있는 얼음", "물 아래에 떠 있는 얼음", "<석얼음>은 수정 속에 보이는 잔술, 물 위나 유리창에 있는 얼음을 뜻합니다."},
            /*43*/{"4", "다음 중 <석얼음>을 볼 수 없는 장소는?", "수정 속", "유리창", "물 위", "물 아래", "<석얼음>은 수정 속에 보이는 잔술, 물 위나 유리창에 있는 얼음을 뜻합니다."},
            /*44*/{"2", "다음 중 옳은 것은?", "<포도시>는 겨우, 간신히라는 뜻의 순우리말이다.", "<푸네기>는 한데 수북이 쌓인 더미를 뜻한다.", "<품바>는 동냥하는 사람을 뜻한다.", "<풋망아지>는 어린 망아지를 뜻한다.", "<푸네기>는 가까운 제살붙이를 뜻합니다."},
            /*45*///{"2", "선린인터넷고등학교에서 간새바람을 맞바람으로 맞으면서 갈 때, 도착하는 장소는?", "노량진", "강남구", "왕십리", "강서구", "<간새>는 동남풍으로, 동남쪽에서 불어오는 바람을 뜻한다."},
            /*46*/{"2", "강쇠바람이 불 수 있는 때는?", "초여름", "초가을", "늦가을", "초겨울", "<강쇠바람>은 첫 가을에 부는 동풍을 뜻합니다."},
            /*47*/{"1", "<꼭지>는 누구를 뜻할까요?", "시집가지 않은 여자", "키가 작은 여자", "어깨가 좁은 여자", "시집 간 여자", "<꼭지>는 시집가지 않은 처녀를 뜻합니다."},
            /*48*/{"3", "<남진겨집>의 뜻은?", "남매", "형제", "부부", "연인", "<남진겨집>은 부부라는 뜻입니다."},
            /*49*/{"1", "<대모>는 자연 상태에서 어디에서 볼 수 있을까요?", "바다", "산", "강", "늪지대", "<대모>는 바다거북을 뜻합니다."},

    };





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtQuiz = getView().findViewById(R.id.txtQuiz);
        bogie1 = getView().findViewById(R.id.bogie1);
        bogie2 = getView().findViewById(R.id.bogie2);
        bogie3 = getView().findViewById(R.id.bogie3);
        bogie4 = getView().findViewById(R.id.bogie4);
        txtQuiz.setText(QuizArr[CurrentNum][1]);
        bogie1.setText(QuizArr[CurrentNum][2]);
        bogie2.setText(QuizArr[CurrentNum][3]);
        bogie3.setText(QuizArr[CurrentNum][4]);
        bogie4.setText(QuizArr[CurrentNum][5]);
        AnswerNum = Integer.parseInt(QuizArr[CurrentNum][0]);
        CurrentAnswer = QuizArr[CurrentNum][6];
        bogie1.setOnClickListener(this::Click1);
        bogie2.setOnClickListener(this::Click2);
        bogie3.setOnClickListener(this::Click3);
        bogie4.setOnClickListener(this::Click4);
}

      public void Click1(View v)
      {
          AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
          if(AnswerNum== 1)
          {
              builder.setTitle("정답입니다!");
          }
          else
          {
              builder.setTitle("오답입니다");
          }

          builder.setMessage(QuizArr[CurrentNum][6]);
          builder.setPositiveButton("다음 문제", new DialogInterface.OnClickListener(){
              @Override
              public void onClick(DialogInterface dialog, int id)
              {
                  CurrentNum = (int)(Math.random()*QuestionNum);
                  txtQuiz.setText(QuizArr[CurrentNum][1]);
                  bogie1.setText(QuizArr[CurrentNum][2]);
                  bogie2.setText(QuizArr[CurrentNum][3]);
                  bogie3.setText(QuizArr[CurrentNum][4]);
                  bogie4.setText(QuizArr[CurrentNum][5]);
                  AnswerNum = Integer.parseInt(QuizArr[CurrentNum][0]);
                  CurrentAnswer = QuizArr[CurrentNum][6];
              }
          });

          builder.setNegativeButton("다시 풀기", new DialogInterface.OnClickListener(){
              @Override
              public void onClick(DialogInterface dialog, int id)
              {

              }
          });

          builder.setNeutralButton("공유하기", new DialogInterface.OnClickListener(){
              @Override
              public void onClick(DialogInterface dialog, int id)
              {

                  Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                  Sharing_intent.setType("text/plain");

                  String Test_Message = txtQuiz.getText() + "\n정답이 궁금하시다면 '띠앗'을 다운로드하세요!\n건전한 우리말 생활, '띠앗'과 함께 만들어가요!\nhttps://tinyurl.com/ti-att/";

                  Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                  Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                  startActivity(Sharing);
                  //Toast.makeText(getActivity().getApplicationContext(), "Neutral Click", Toast.LENGTH_SHORT).show();
              }
          });

          AlertDialog alertDialog = builder.create();
          alertDialog.show();

      }

    public void Click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(AnswerNum== 2)
        {
            builder.setTitle("정답입니다!");
        }
        else
        {
            builder.setTitle("오답입니다");
        }

        builder.setMessage(QuizArr[CurrentNum][6]);
        builder.setPositiveButton("다음 문제", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                CurrentNum = (int)(Math.random()*QuestionNum);
                txtQuiz.setText(QuizArr[CurrentNum][1]);
                bogie1.setText(QuizArr[CurrentNum][2]);
                bogie2.setText(QuizArr[CurrentNum][3]);
                bogie3.setText(QuizArr[CurrentNum][4]);
                bogie4.setText(QuizArr[CurrentNum][5]);
                AnswerNum = Integer.parseInt(QuizArr[CurrentNum][0]);
                CurrentAnswer = QuizArr[CurrentNum][6];
            }
        });

        builder.setNegativeButton("다시 풀기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

            }
        });
        builder.setNeutralButton("공유하기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                String Test_Message = txtQuiz.getText() + "\n정답이 궁금하시다면 '띠앗'을 다운로드하세요!\n건전한 우리말 생활, '띠앗'과 함께 만들어가요!\nhttps://tinyurl.com/ti-att/";

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);
                //Toast.makeText(getActivity().getApplicationContext(), "Neutral Click", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void Click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(AnswerNum== 3)
        {
            builder.setTitle("정답입니다!");
        }
        else
        {
            builder.setTitle("오답입니다");
        }

        builder.setMessage(QuizArr[CurrentNum][6]);
        builder.setPositiveButton("다음 문제", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                CurrentNum = (int)(Math.random()*QuestionNum);
                txtQuiz.setText(QuizArr[CurrentNum][1]);
                bogie1.setText(QuizArr[CurrentNum][2]);
                bogie2.setText(QuizArr[CurrentNum][3]);
                bogie3.setText(QuizArr[CurrentNum][4]);
                bogie4.setText(QuizArr[CurrentNum][5]);
                AnswerNum = Integer.parseInt(QuizArr[CurrentNum][0]);
                CurrentAnswer = QuizArr[CurrentNum][6];
            }
        });

        builder.setNegativeButton("다시 풀기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

            }
        });
        builder.setNeutralButton("공유하기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                String Test_Message = txtQuiz.getText() + "\n정답이 궁금하시다면 '띠앗'을 다운로드하세요!\n건전한 우리말 생활, '띠앗'과 함께 만들어가요!\nhttps://tinyurl.com/ti-att/";

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);
                //Toast.makeText(getActivity().getApplicationContext(), "Neutral Click", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void Click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(AnswerNum== 4)
        {
            builder.setTitle("정답입니다!");
        }
        else
        {
            builder.setTitle("오답입니다");
        }

        builder.setMessage(QuizArr[CurrentNum][6]);
        builder.setPositiveButton("다음 문제", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                CurrentNum = (int)(Math.random()*QuestionNum);
                txtQuiz.setText(QuizArr[CurrentNum][1]);
                bogie1.setText(QuizArr[CurrentNum][2]);
                bogie2.setText(QuizArr[CurrentNum][3]);
                bogie3.setText(QuizArr[CurrentNum][4]);
                bogie4.setText(QuizArr[CurrentNum][5]);
                AnswerNum = Integer.parseInt(QuizArr[CurrentNum][0]);
                CurrentAnswer = QuizArr[CurrentNum][6];
            }
        });

        builder.setNegativeButton("다시 풀기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

            }
        });
        builder.setNeutralButton("공유하기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                String Test_Message = txtQuiz.getText() + "\n정답이 궁금하시다면 '띠앗'을 다운로드하세요!\n건전한 우리말 생활, '띠앗'과 함께 만들어가요!\nhttps://tinyurl.com/ti-att/";

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);
                //Toast.makeText(getActivity().getApplicationContext(), "Neutral Click", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quiz, container, false);
        return root;





    }
}