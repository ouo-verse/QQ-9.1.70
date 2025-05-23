package y60;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.i;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends c implements View.OnClickListener {
    private TextView E;
    private ImageView F;
    private ImageView G;
    private QCircleAsyncTextView H;
    private View I;
    private View J;
    private String K = "";

    private void D() {
        QFSCommentInfo a16 = b70.a.a(this.f449511d, k(), g(), this.f449512e, false);
        a16.mHintText = this.K;
        o("event_open_comment", a16);
        o("event_open_comment_input", a16);
    }

    private void E() {
        if (this.I == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "[updateBackgroundResource] send comment layout should not be null.");
            return;
        }
        int w3 = w();
        if (w3 == -1) {
            this.I.setBackgroundDrawable(null);
        } else {
            this.I.setBackgroundResource(w3);
        }
    }

    private void G(String[] strArr) {
        String v3 = v(strArr);
        this.K = v3;
        if (TextUtils.isEmpty(v3)) {
            q(8);
            return;
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.H;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setText(this.K);
        }
        View view = this.J;
        if (view != null) {
            view.setBackgroundResource(u());
        }
        E();
        p(new i(128, true));
    }

    private void H(@NonNull Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "[updateSendCommentText] should not be null.");
            return;
        }
        if (this.E == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "[updateSendCommentText] send comment text should not be null.");
            return;
        }
        try {
            this.E.setText(resources.getString(x()));
        } catch (Throwable th5) {
            QLog.e("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "[updateSendCommentText] error", th5);
        }
    }

    private void s(View view) {
        if (view != null && this.f449511d != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EXCON_COMMENT_FRAME);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.f449511d));
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            int i3 = 1;
            try {
                qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.f449511d.reportInfoForClient.get().toByteArray());
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "dtCustomClickPraiseView, transferInfo error");
            }
            if (B()) {
                i3 = 2;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTBAR_TYPE, Integer.valueOf(i3));
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, view, buildElementParams);
        }
    }

    private void t() {
        int i3;
        View view = this.J;
        if (view != null && this.f449511d != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EXCON_COMMENT_FRAME);
            HashMap hashMap = new HashMap();
            if (B()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTBAR_TYPE, Integer.valueOf(i3));
            VideoReport.setElementParams(this.J, hashMap);
        }
    }

    private String v(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            try {
                return strArr[this.f449512e % strArr.length];
            } catch (Throwable th5) {
                QLog.e("BGV-QFSAbsFeedBottomGuideCommentHolder", 1, "[getCurrentDisplayText] error: ", th5);
            }
        }
        return "";
    }

    private void z(@NonNull Context context, @NonNull View view) {
        this.E = (TextView) view.findViewById(R.id.f39901cx);
        this.F = (ImageView) view.findViewById(R.id.f39871cu);
        this.G = (ImageView) view.findViewById(R.id.f39861ct);
        this.H = (QCircleAsyncTextView) view.findViewById(R.id.f39911cy);
        this.I = view.findViewById(R.id.f39891cw);
        this.J = view;
        view.setOnClickListener(this);
        this.H.setOnClickListener(this);
        I(context, C());
        H(context);
        F(A());
    }

    protected abstract boolean A();

    protected abstract boolean B();

    protected abstract boolean C();

    protected void F(boolean z16) {
        int i3;
        ImageView imageView = this.G;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        r(imageView, i3);
        ImageView imageView2 = this.F;
        if (z16) {
            i16 = 8;
        }
        r(imageView2, i16);
    }

    protected void I(Context context, boolean z16) {
        Resources resources;
        int color;
        if (this.E == null) {
            return;
        }
        if (context == null) {
            resources = null;
        } else {
            resources = context.getResources();
        }
        if (resources == null) {
            return;
        }
        if (z16) {
            color = resources.getColor(R.color.bfp);
        } else {
            color = resources.getColor(R.color.bfq);
        }
        this.E.setTextColor(color);
    }

    @Override // y60.c
    protected void m(@NonNull Context context, @NonNull View view) {
        z(context, view);
        G(y());
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (R.id.f39841cr == id5 || R.id.f39911cy == id5) {
            D();
            s(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected abstract int u();

    protected int w() {
        return -1;
    }

    protected abstract int x();

    protected abstract String[] y();
}
