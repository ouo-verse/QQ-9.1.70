package wn2;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.y;
import java.util.List;
import wn2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends f implements com.tencent.mobileqq.search.model.o {

    /* renamed from: p0, reason: collision with root package name */
    private CharSequence f445919p0;

    public i(AppInterface appInterface, int i3, String str, List<f.b> list, long j3) {
        super(appInterface, i3, str, list, j3);
    }

    @Override // wn2.f, com.tencent.mobileqq.search.model.k
    public String K() {
        if (y.a()) {
            return super.K();
        }
        return this.f445919p0.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wn2.f
    public void V() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        int i3;
        String str;
        if (y.a()) {
            super.V();
            return;
        }
        if (SearchUtils.F0(this.I)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.Y != null) {
                spannableStringBuilder.append((CharSequence) "\u5305\u542b: ");
                int size = this.f445888f0.size() - 1;
                int i16 = 0;
                while (true) {
                    if (size >= 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (i16 < 10) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z18 || !z19) {
                        break;
                    }
                    spannableStringBuilder.append(SearchUtils.E(this.f445888f0.get(size), this.f445889g0.get(size), 6, false));
                    i16++;
                    spannableStringBuilder.append((CharSequence) "\u3001");
                    size--;
                }
                int i17 = 0;
                while (true) {
                    if (i17 < this.Y.size()) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (i16 < 10) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (!z26 || !z27) {
                        break;
                    }
                    f.b bVar = this.Y.get(i17);
                    if (!this.f445890h0.contains(bVar)) {
                        if (this.f445889g0.size() == 1) {
                            i3 = bVar.f445906f;
                        } else {
                            i3 = bVar.f445907g;
                        }
                        if (i3 == 66) {
                            str = bVar.f445903c;
                        } else if (i3 == 88) {
                            str = bVar.f445902b;
                        } else if (i3 == 99) {
                            str = bVar.f445904d;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            i16++;
                            spannableStringBuilder.append((CharSequence) str);
                            spannableStringBuilder.append((CharSequence) "\u3001");
                        }
                    }
                    i17++;
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\u3001') {
                this.f445887e0 = spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1);
            } else {
                this.f445887e0 = spannableStringBuilder;
            }
            this.f445919p0 = this.f445891i0.wMemberNum + HardCodeUtil.qqStr(R.string.l3d);
            return;
        }
        this.f445887e0 = HardCodeUtil.qqStr(R.string.l3m);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (!this.f445891i0.hasSetTroopName()) {
            spannableStringBuilder2.append((CharSequence) String.valueOf(this.f445891i0.wMemberNum));
        } else if (!this.f445890h0.isEmpty() && this.Y != null) {
            int size2 = this.f445888f0.size() - 1;
            int i18 = 0;
            while (true) {
                if (size2 >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i18 < 10) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 || !z17) {
                    break;
                }
                spannableStringBuilder2.append(SearchUtils.E(this.f445888f0.get(size2), this.f445889g0.get(size2), 6, false));
                i18++;
                if (size2 > 0) {
                    spannableStringBuilder2.append((CharSequence) "\u3001");
                }
                size2--;
            }
        }
        this.f445919p0 = spannableStringBuilder2;
    }

    @Override // com.tencent.mobileqq.search.model.o
    public TroopInfo a() {
        return this.f445891i0;
    }

    @Override // wn2.f, com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (!SearchUtils.F0(this.I)) {
            SearchUtils.l1(view, this);
        }
    }
}
