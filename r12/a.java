package r12;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import r12.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f430500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b extends ReportDialog {
        private final Context C;
        private final C11105a D;
        private View E;
        private final Runnable F;

        public b(Context context, C11105a c11105a) {
            super(context, R.style.f173523f9);
            this.F = new Runnable() { // from class: r12.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.dismiss();
                }
            };
            this.C = context;
            this.D = c11105a;
            initView();
        }

        public static int O(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return R.drawable.guild_token_common_black_tips_icon_info;
                }
                return R.drawable.guild_token_qzone_commo_black_tips_icon_success;
            }
            return R.drawable.guild_token_qzone_commo_black_tips_icon_caution;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            dismiss();
            this.D.f430505e.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        private void Q(boolean z16) {
            View findViewById = this.E.findViewById(R.id.x2i);
            findViewById.setElevation(20.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.C.getResources().getColor(R.color.qui_common_bg_top_light));
            gradientDrawable.setCornerRadius(x.c(this.C, 12.0f));
            findViewById.setBackgroundDrawable(gradientDrawable);
        }

        private void R(boolean z16) {
            Drawable drawable = this.C.getResources().getDrawable(O(this.D.f430503c));
            ImageView imageView = (ImageView) this.E.findViewById(R.id.x2j);
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                if (z16) {
                    int c16 = x.c(this.C, 28.0f);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = c16;
                    layoutParams.width = c16;
                    return;
                }
                return;
            }
            imageView.setVisibility(8);
        }

        private void S(boolean z16) {
            TextView textView = (TextView) this.E.findViewById(R.id.x2k);
            textView.setText(this.D.f430502b);
            if (z16) {
                textView.setTextSize(2, 16.0f);
            }
            if (this.D.f430505e != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: r12.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.b.this.P(view);
                    }
                });
            }
        }

        private void U(boolean z16) {
            Resources resources = this.C.getResources();
            TextView textView = (TextView) this.E.findViewById(R.id.x2l);
            textView.setText(this.D.f430501a);
            if (z16) {
                textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
                textView.setTextSize(2, 16.0f);
            } else {
                textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
            }
        }

        private void initView() {
            this.E = LayoutInflater.from(this.C).inflate(R.layout.f9z, (ViewGroup) null);
            boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
            Q(isNowSimpleUI);
            R(isNowSimpleUI);
            U(isNowSimpleUI);
            S(isNowSimpleUI);
            setContentView(this.E);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(48);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
        }

        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
        public void show() {
            long j3;
            View view = this.E;
            Runnable runnable = this.F;
            if (this.D.f430504d == 0) {
                j3 = 4000;
            } else {
                j3 = 7000;
            }
            view.postDelayed(runnable, j3);
            super.show();
        }
    }

    a(Context context, C11105a c11105a) {
        this.f430500a = new b(context, c11105a);
    }

    public static a a(Context context, C11105a c11105a) {
        return new a(context, c11105a);
    }

    public void b() {
        this.f430500a.show();
    }

    /* compiled from: P */
    /* renamed from: r12.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C11105a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public CharSequence f430501a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public CharSequence f430502b;

        /* renamed from: c, reason: collision with root package name */
        public int f430503c;

        /* renamed from: d, reason: collision with root package name */
        public int f430504d;

        /* renamed from: e, reason: collision with root package name */
        public View.OnClickListener f430505e;

        public C11105a(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, View.OnClickListener onClickListener) {
            this.f430503c = 0;
            this.f430504d = 0;
            this.f430501a = charSequence;
            this.f430502b = charSequence2;
            this.f430505e = onClickListener;
        }

        public C11105a(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i3, int i16, View.OnClickListener onClickListener) {
            this.f430501a = charSequence;
            this.f430502b = charSequence2;
            this.f430503c = i3;
            this.f430504d = i16;
            this.f430505e = onClickListener;
        }
    }
}
