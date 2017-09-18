package hooooong.com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Android Hong on 2017-09-18.
 */
// View 를 상속받아 생성
public class CustomView extends View {

    /**
     * SourceCode 에서 생성할 때 사용하는 생성자
     *
     * @param context
     */
    public CustomView(Context context){
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
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * View 그리기
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 사각형 그리기
         */
        // 물감 - 겉 모양을 결정하는 도구(색, 두께 정하기)
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);

        // canvas : 붓으로 그려지는 도화지(화면)
        // drawRect : 붓
        canvas.drawRect(100, 100, 200, 200, paint);
    }
}
