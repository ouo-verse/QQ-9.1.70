package wc4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a implements ViewBinding {
    public final EditText A;

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f445400a;

    /* renamed from: b, reason: collision with root package name */
    public final Spinner f445401b;

    /* renamed from: c, reason: collision with root package name */
    public final Spinner f445402c;

    /* renamed from: d, reason: collision with root package name */
    public final Spinner f445403d;

    /* renamed from: e, reason: collision with root package name */
    public final Button f445404e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f445405f;

    /* renamed from: g, reason: collision with root package name */
    public final Button f445406g;

    /* renamed from: h, reason: collision with root package name */
    public final Button f445407h;

    /* renamed from: i, reason: collision with root package name */
    public final Button f445408i;

    /* renamed from: j, reason: collision with root package name */
    public final Button f445409j;

    /* renamed from: k, reason: collision with root package name */
    public final Button f445410k;

    /* renamed from: l, reason: collision with root package name */
    public final Spinner f445411l;

    /* renamed from: m, reason: collision with root package name */
    public final Spinner f445412m;

    /* renamed from: n, reason: collision with root package name */
    public final EditText f445413n;

    /* renamed from: o, reason: collision with root package name */
    public final CheckBox f445414o;

    /* renamed from: p, reason: collision with root package name */
    public final Button f445415p;

    /* renamed from: q, reason: collision with root package name */
    public final EditText f445416q;

    /* renamed from: r, reason: collision with root package name */
    public final Spinner f445417r;

    /* renamed from: s, reason: collision with root package name */
    public final CheckBox f445418s;

    /* renamed from: t, reason: collision with root package name */
    public final CheckBox f445419t;

    /* renamed from: u, reason: collision with root package name */
    public final Spinner f445420u;

    /* renamed from: v, reason: collision with root package name */
    public final EditText f445421v;

    /* renamed from: w, reason: collision with root package name */
    public final EditText f445422w;

    /* renamed from: x, reason: collision with root package name */
    public final LinearLayout f445423x;

    /* renamed from: y, reason: collision with root package name */
    public final CheckBox f445424y;

    /* renamed from: z, reason: collision with root package name */
    public final CheckBox f445425z;

    a(ScrollView scrollView, Spinner spinner, Spinner spinner2, Spinner spinner3, Button button, LinearLayout linearLayout, Button button2, Button button3, Button button4, Button button5, Button button6, Spinner spinner4, Spinner spinner5, EditText editText, CheckBox checkBox, Button button7, EditText editText2, Spinner spinner6, CheckBox checkBox2, CheckBox checkBox3, Spinner spinner7, EditText editText3, EditText editText4, LinearLayout linearLayout2, CheckBox checkBox4, CheckBox checkBox5, EditText editText5) {
        this.f445400a = scrollView;
        this.f445401b = spinner;
        this.f445402c = spinner2;
        this.f445403d = spinner3;
        this.f445404e = button;
        this.f445405f = linearLayout;
        this.f445406g = button2;
        this.f445407h = button3;
        this.f445408i = button4;
        this.f445409j = button5;
        this.f445410k = button6;
        this.f445411l = spinner4;
        this.f445412m = spinner5;
        this.f445413n = editText;
        this.f445414o = checkBox;
        this.f445415p = button7;
        this.f445416q = editText2;
        this.f445417r = spinner6;
        this.f445418s = checkBox2;
        this.f445419t = checkBox3;
        this.f445420u = spinner7;
        this.f445421v = editText3;
        this.f445422w = editText4;
        this.f445423x = linearLayout2;
        this.f445424y = checkBox4;
        this.f445425z = checkBox5;
        this.A = editText5;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f445400a;
    }

    public static a g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static a h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d2e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static a e(View view) {
        int i3 = R.id.p9p;
        Spinner spinner = (Spinner) view.findViewById(R.id.p9p);
        if (spinner != null) {
            i3 = R.id.p9q;
            Spinner spinner2 = (Spinner) view.findViewById(R.id.p9q);
            if (spinner2 != null) {
                i3 = R.id.p9w;
                Spinner spinner3 = (Spinner) view.findViewById(R.id.p9w);
                if (spinner3 != null) {
                    i3 = R.id.f163331pk0;
                    Button button = (Button) view.findViewById(R.id.f163331pk0);
                    if (button != null) {
                        i3 = R.id.plw;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.plw);
                        if (linearLayout != null) {
                            i3 = R.id.f163362pq1;
                            Button button2 = (Button) view.findViewById(R.id.f163362pq1);
                            if (button2 != null) {
                                i3 = R.id.f163363pq2;
                                Button button3 = (Button) view.findViewById(R.id.f163363pq2);
                                if (button3 != null) {
                                    i3 = R.id.f163364pq3;
                                    Button button4 = (Button) view.findViewById(R.id.f163364pq3);
                                    if (button4 != null) {
                                        i3 = R.id.f163365pq4;
                                        Button button5 = (Button) view.findViewById(R.id.f163365pq4);
                                        if (button5 != null) {
                                            i3 = R.id.pq5;
                                            Button button6 = (Button) view.findViewById(R.id.pq5);
                                            if (button6 != null) {
                                                i3 = R.id.prv;
                                                Spinner spinner4 = (Spinner) view.findViewById(R.id.prv);
                                                if (spinner4 != null) {
                                                    i3 = R.id.prw;
                                                    Spinner spinner5 = (Spinner) view.findViewById(R.id.prw);
                                                    if (spinner5 != null) {
                                                        i3 = R.id.pz7;
                                                        EditText editText = (EditText) view.findViewById(R.id.pz7);
                                                        if (editText != null) {
                                                            i3 = R.id.q2p;
                                                            CheckBox checkBox = (CheckBox) view.findViewById(R.id.q2p);
                                                            if (checkBox != null) {
                                                                i3 = R.id.f163500qg3;
                                                                Button button7 = (Button) view.findViewById(R.id.f163500qg3);
                                                                if (button7 != null) {
                                                                    i3 = R.id.qgl;
                                                                    EditText editText2 = (EditText) view.findViewById(R.id.qgl);
                                                                    if (editText2 != null) {
                                                                        i3 = R.id.qk8;
                                                                        Spinner spinner6 = (Spinner) view.findViewById(R.id.qk8);
                                                                        if (spinner6 != null) {
                                                                            i3 = R.id.qkq;
                                                                            CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.qkq);
                                                                            if (checkBox2 != null) {
                                                                                i3 = R.id.qne;
                                                                                CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.qne);
                                                                                if (checkBox3 != null) {
                                                                                    i3 = R.id.quy;
                                                                                    Spinner spinner7 = (Spinner) view.findViewById(R.id.quy);
                                                                                    if (spinner7 != null) {
                                                                                        i3 = R.id.qv7;
                                                                                        EditText editText3 = (EditText) view.findViewById(R.id.qv7);
                                                                                        if (editText3 != null) {
                                                                                            i3 = R.id.qv8;
                                                                                            EditText editText4 = (EditText) view.findViewById(R.id.qv8);
                                                                                            if (editText4 != null) {
                                                                                                i3 = R.id.qv9;
                                                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qv9);
                                                                                                if (linearLayout2 != null) {
                                                                                                    i3 = R.id.qvo;
                                                                                                    CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.qvo);
                                                                                                    if (checkBox4 != null) {
                                                                                                        i3 = R.id.qvq;
                                                                                                        CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.qvq);
                                                                                                        if (checkBox5 != null) {
                                                                                                            i3 = R.id.qyy;
                                                                                                            EditText editText5 = (EditText) view.findViewById(R.id.qyy);
                                                                                                            if (editText5 != null) {
                                                                                                                return new a((ScrollView) view, spinner, spinner2, spinner3, button, linearLayout, button2, button3, button4, button5, button6, spinner4, spinner5, editText, checkBox, button7, editText2, spinner6, checkBox2, checkBox3, spinner7, editText3, editText4, linearLayout2, checkBox4, checkBox5, editText5);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
