package uc2;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.w;
import com.tencent.mobileqq.onlinestatus.view.av;
import com.tencent.mobileqq.onlinestatus.x;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import uc2.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends c<com.tencent.mobileqq.onlinestatus.model.d, C11337a> {
    private final int E;
    private final AppInterface F;
    private int G;
    private int H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: uc2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C11337a extends c.a<com.tencent.mobileqq.onlinestatus.model.d> implements FaceDrawable.OnLoadingStateChangeListener {
        private AppInterface E;
        ImageView F;
        TextView G;
        TextView H;
        QUIShimmerImageView I;
        FrameLayout J;

        C11337a(AppInterface appInterface, @NonNull View view) {
            super(view);
            this.F = (ImageView) view.findViewById(R.id.y9b);
            this.G = (TextView) view.findViewById(R.id.f111506le);
            this.H = (TextView) view.findViewById(R.id.f111516lf);
            this.I = (QUIShimmerImageView) view.findViewById(R.id.y9e);
            this.J = (FrameLayout) view.findViewById(R.id.y9c);
            this.I.setImageDrawable(new av());
            this.E = appInterface;
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
        public void onLoadingStateChanged(int i3, int i16) {
            if (i16 != 1) {
                return;
            }
            Object tag = this.F.getTag();
            if (tag instanceof String) {
                this.F.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.E, (String) tag, (byte) 3));
            }
        }
    }

    public a(Context context) {
        super(context);
        this.F = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = context.getResources().getConfiguration().orientation;
        int screenWidth = ViewUtils.getScreenWidth();
        if (AppSetting.t(context)) {
            Size c16 = m.c((FragmentActivity) context);
            if (PadUtil.a(context) == DeviceType.FOLD) {
                if (c16 != null) {
                    screenWidth = c16.getWidth();
                }
            } else if (i3 == 2) {
                screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
                if (c16 != null) {
                    screenWidth -= c16.getWidth();
                }
            }
        }
        this.E = (screenWidth - ViewUtils.dpToPx(60.0f)) / 5;
    }

    private void y0(QUIShimmerImageView qUIShimmerImageView) {
        qUIShimmerImageView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qUIShimmerImageView, BasicAnimation.KeyPath.ROTATION, 0.0f, 360.0f);
        ofFloat.setDuration(2500L);
        ofFloat.setRepeatCount(0);
        ofFloat.start();
    }

    @Override // uc2.c
    public int m0(int i3) {
        return 0;
    }

    public boolean t0(int i3) {
        if (this.G - 1 == l0(i3) && this.H > this.G) {
            return true;
        }
        return false;
    }

    @Override // uc2.c
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void o0(C11337a c11337a, int i3) {
        com.tencent.mobileqq.onlinestatus.model.d item;
        if (c11337a == null || (item = getItem(i3)) == null) {
            return;
        }
        if (t0(i3)) {
            c11337a.F.setImageDrawable(null);
            c11337a.H.setVisibility(0);
            c11337a.F.setImageDrawable(new ColorDrawable(this.D.getResources().getColor(R.color.cex)));
            c11337a.G.setVisibility(8);
            c11337a.H.setText(bs.v(this.H - this.G));
            c11337a.itemView.setTag(R.id.f9220579, 1);
            c11337a.F.setTag(null);
            return;
        }
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.F, 1, item.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), 3, defaultDrawable, defaultDrawable, c11337a);
        c11337a.F.setTag(item.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        c11337a.F.setImageDrawable(faceDrawable);
        c11337a.G.setText(item.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().m());
        c11337a.G.setVisibility(0);
        c11337a.H.setVisibility(8);
        c11337a.itemView.setTag(R.id.f9220579, null);
        if (AppSetting.o(BaseApplication.getContext())) {
            ViewGroup.LayoutParams layoutParams = c11337a.J.getLayoutParams();
            layoutParams.width = ViewUtils.dpToPx(30.0f);
            layoutParams.height = ViewUtils.dpToPx(30.0f);
            c11337a.J.setLayoutParams(layoutParams);
            int dpToPx = ViewUtils.dpToPx(25.0f);
            ViewGroup.LayoutParams layoutParams2 = c11337a.F.getLayoutParams();
            layoutParams2.width = dpToPx;
            layoutParams2.height = dpToPx;
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                int dpToPx2 = ViewUtils.dpToPx(2.5f);
                ((FrameLayout.LayoutParams) layoutParams2).setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            }
            c11337a.F.setLayoutParams(layoutParams2);
        }
        c11337a.I.setVisibility(8);
        if (OnlineStatusToggleUtils.n()) {
            if (x.e(item.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), item.getStatus().F())) {
                y0(c11337a.I);
                w.b(true);
            } else {
                w.b(false);
            }
        }
    }

    @Override // uc2.c
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public C11337a q0(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fdc, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = this.E;
        inflate.setLayoutParams(layoutParams);
        return new C11337a(this.F, inflate);
    }

    public void w0(int i3) {
        this.G = i3;
    }

    public void x0(int i3) {
        this.H = i3;
    }
}
