package yg2;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qqexpand.feed.LabelInfo;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final Context f450263d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f450264e = false;

    /* renamed from: f, reason: collision with root package name */
    private final List<LabelInfo> f450265f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    protected class a {

        /* renamed from: a, reason: collision with root package name */
        int f450266a;

        /* renamed from: b, reason: collision with root package name */
        TextView f450267b;

        protected a() {
        }
    }

    public c(Context context) {
        this.f450263d = context;
    }

    private Drawable c(int i3, int i16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, f(i3));
        stateListDrawable.addState(new int[]{R.attr.state_focused}, f(i3));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, f(i3));
        stateListDrawable.addState(new int[0], f(i16));
        return stateListDrawable;
    }

    private Drawable f(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(i3);
        if (this.f450264e) {
            gradientDrawable.setStroke(1, -1);
        }
        return gradientDrawable;
    }

    private SpannableString i(Drawable drawable) {
        SpannableString spannableString = new SpannableString(" ");
        int f16 = BaseAIOUtils.f(11.0f, this.f450263d.getResources());
        drawable.setBounds(0, 0, f16, f16);
        spannableString.setSpan(new VerticalCenterImageSpan(drawable, 0), 0, 1, 33);
        return spannableString;
    }

    public void a(List<LabelInfo> list) {
        this.f450265f.addAll(list);
    }

    public void b() {
        this.f450265f.clear();
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public LabelInfo getItem(int i3) {
        return this.f450265f.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f450265f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public void h(boolean z16) {
        this.f450264e = z16;
    }

    private ColorStateList g(int i3, int i16, int i17, int i18) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i16, i17, i3, i17, i18, i3});
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        int parseColor;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.tencent.mobileqq.R.layout.gwx, (ViewGroup) null, false);
            aVar = new a();
            aVar.f450267b = (TextView) view.findViewById(com.tencent.mobileqq.R.id.f107846bi);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        LabelInfo item = getItem(i3);
        if (item != null) {
            aVar.f450266a = i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Drawable drawable = item.f263550e;
            if (drawable != null) {
                spannableStringBuilder.append((CharSequence) i(drawable));
            }
            if (!TextUtils.isEmpty(item.f263547b)) {
                spannableStringBuilder.append((CharSequence) item.f263547b);
            }
            TextView textView = aVar.f450267b;
            boolean isEmpty = TextUtils.isEmpty(spannableStringBuilder);
            CharSequence charSequence = spannableStringBuilder;
            if (isEmpty) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (TextUtils.isEmpty(item.f263548c)) {
                parseColor = Color.parseColor("#FF80BF");
                aVar.f450267b.setBackgroundDrawable(c(d(0.2f, parseColor), d(0.2f, parseColor)));
            } else {
                parseColor = Color.parseColor(item.f263548c);
                if (TextUtils.isEmpty(item.f263549d)) {
                    aVar.f450267b.setBackgroundDrawable(c(d(0.2f, parseColor), d(0.2f, parseColor)));
                } else {
                    aVar.f450267b.setBackgroundDrawable(c(Color.parseColor(item.f263549d), Color.parseColor(item.f263549d)));
                }
            }
            aVar.f450267b.setTextColor(g(parseColor, parseColor, parseColor, parseColor));
        }
        return view;
    }

    private int d(float f16, int i3) {
        return (Math.min(255, Math.max(0, (int) (f16 * 255.0f))) << 24) + (i3 & 16777215);
    }
}
