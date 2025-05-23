package sx2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets.QFSBlackStrokeTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.danmaku.manager.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import feedcloud.FeedCloudMeta$StBarrage;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends m70.b {

    /* renamed from: d, reason: collision with root package name */
    protected QFSBlackStrokeTextView f434941d;

    /* renamed from: e, reason: collision with root package name */
    private volatile RectF f434942e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Paint f434943f;

    public e(Context context) {
        super(context, R.layout.i2a);
        this.f434942e = new RectF();
        this.f434943f = new Paint();
    }

    private int n(Context context, boolean z16) {
        if (ScreenUtils.isPortrait() && !z16) {
            return context.getColor(R.color.ald);
        }
        return context.getColor(R.color.f158017al3);
    }

    private void o(@NonNull m70.a aVar) {
        FeedCloudMeta$StBarrage a16 = aVar.a();
        m(this.f434941d, i(a16));
        QFSBlackStrokeTextView qFSBlackStrokeTextView = this.f434941d;
        qFSBlackStrokeTextView.setTextColor(n(qFSBlackStrokeTextView.getContext(), l.i(a16)));
    }

    @Override // uz3.k.a
    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        this.f434942e.set(0.0f, 0.0f, this.f440689a.getMeasuredWidth(), this.f440689a.getMeasuredHeight());
        this.f434943f.setAlpha((int) (this.f440689a.getAlpha() * 255.0f));
        int saveLayer = canvas.saveLayer(this.f434942e, this.f434943f, 31);
        this.f440689a.draw(canvas);
        canvas.restoreToCount(saveLayer);
    }

    @Override // m70.b
    public void k(m70.a aVar) {
        if (aVar == null) {
            QLog.d("QDM-TVideoNormalBarrageHolder", 1, "[onBindView] param should not be null.");
        } else {
            o(aVar);
        }
    }

    @Override // m70.b
    public void l(View view) {
        if (view == null) {
            return;
        }
        this.f434941d = (QFSBlackStrokeTextView) view.findViewById(R.id.v9l);
    }

    public e(Context context, int i3) {
        super(context, i3);
        this.f434942e = new RectF();
        this.f434943f = new Paint();
    }
}
