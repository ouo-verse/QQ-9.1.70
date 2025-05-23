package yo0;

import android.text.SpannableString;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f450716a;

    /* renamed from: b, reason: collision with root package name */
    public final SpannableString f450717b;

    public a(int i3, SpannableString spannableString) {
        this.f450716a = i3;
        this.f450717b = spannableString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f450716a != aVar.f450716a) {
            return false;
        }
        SpannableString spannableString = this.f450717b;
        SpannableString spannableString2 = aVar.f450717b;
        if (spannableString != null) {
            return spannableString.equals(spannableString2);
        }
        if (spannableString2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.f450716a * 31;
        SpannableString spannableString = this.f450717b;
        if (spannableString != null) {
            i3 = spannableString.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    public String toString() {
        return "AtTag{startIndex=" + this.f450716a + ", atSpan=" + ((CharSequence) this.f450717b) + '}';
    }
}
