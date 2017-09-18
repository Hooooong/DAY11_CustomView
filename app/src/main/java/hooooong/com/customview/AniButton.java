package hooooong.com.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * animation 속성이 true 일 경우
 *
 * Scale 애니메이션을 사용해서
 * 클릭 시 살짝 커졌다 작아지는 버튼을 만들어 보세요.
 */

// Button 을 상속받아도 되지만
// android.support.v7.widget.AppCompatButton 을 상속받아
// 하위버전에도 Material Design 이 적용된 Button 을 사용하게 한다.
public class AniButton extends AppCompatButton implements View.OnTouchListener{

    /**
     * SourceCode 에서 생성할 때 사용하는 생성자
     *
     * @param context
     */
    public AniButton(Context context){
        super(context);
    }

    /**
     * xml 에서 Tag 로 사용할 때 시스템에서 호출해주는 생성자
     * View 를 xml 에 넣기 때문에 AttributeSet 이 있어야 한다.
     * ( 3, 4 번째 매개변수는 테마 관련 변수이다.)
     *
     * @param context
     * @param attrs
     */
    public AniButton(final Context context, AttributeSet attrs) {
        super(context, attrs);

        // 1. attrs.xml 에 정의된 속성을 가져온다.
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AniButton);

        // 2. 해당 이름으로 정의된 속성의 갯수를 가져온다.
        int size = typedArray.getIndexCount();

        Log.d("AniButton ", "Size : " + size);

        // 3. 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
        for (int i = 0; i < size; i++) {
            // 3-1. 현재 배열에 있는 속성 ID 를 가져오기
            int currentAttr = typedArray.getIndex(i);
            // 3-2. ID 값마다 switch-case 처리
            switch (currentAttr) {
                case R.styleable.AniButton_animation:
                    String animation = typedArray.getString(currentAttr);
                    // animation 이 null 일 경우에는
                    // animation.equals("true") 가 Exception 이 날 수 있다.
                    // 그러므로 "비교할문자열".equals(객체) 로 비교한다.
                    if ("true".equals(animation)) {
                        setText("[Animation]\n" + getText());
                        setOnTouchListener(this);
                    }
                    break;
            }
        }

    }

    /**
     * Button Animation 정의
     * @param view
     */
    private void animationScale(View view){
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.0F);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.0F);

//        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f);
//        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f);

        AnimatorSet animatorSet1 = new AnimatorSet();
//        AnimatorSet animatorSet2 = new AnimatorSet();
//        AnimatorSet animatorSet3 = new AnimatorSet();

        animatorSet1.playTogether(scaleUpX, scaleUpY);
//        animatorSet2.playTogether(scaleDownX,scaleDownY);
        animatorSet1.setDuration(1000);
//        animatorSet2.setDuration(1000);

//        animatorSet3.playSequentially(animatorSet1,animatorSet2);
        animatorSet1.start();
    }



    /**
     * Touch Listener 정의
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                animationScale(v);
                // 눌렀을 떄
                break;
        }
        return false;
    }
}
