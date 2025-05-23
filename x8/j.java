package x8;

import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private Pattern f447407a;

    /* renamed from: b, reason: collision with root package name */
    private int f447408b;

    /* renamed from: c, reason: collision with root package name */
    private String f447409c;

    /* renamed from: d, reason: collision with root package name */
    private Matcher f447410d;

    /* renamed from: e, reason: collision with root package name */
    protected String f447411e;

    /* renamed from: f, reason: collision with root package name */
    private int f447412f = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f447413g = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Pattern pattern) {
        this.f447407a = pattern;
    }

    private void a() {
        if (this.f447413g) {
            boolean find = this.f447410d.find();
            this.f447413g = find;
            if (find) {
                this.f447412f = this.f447410d.start();
            }
        }
    }

    public int b() {
        return this.f447408b;
    }

    public abstract ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList);

    public boolean d(int i3) {
        Matcher matcher;
        int i16;
        if (this.f447409c != null && (matcher = this.f447410d) != null && (i16 = this.f447412f) <= i3 && this.f447413g) {
            if (i16 == i3) {
                this.f447411e = matcher.group();
                this.f447408b = this.f447410d.end();
                a();
                return true;
            }
            a();
        }
        return false;
    }

    public void e(String str) {
        this.f447409c = str;
        this.f447410d = this.f447407a.matcher(str);
        a();
    }
}
