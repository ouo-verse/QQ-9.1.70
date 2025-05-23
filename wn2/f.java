package wn2;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends com.tencent.mobileqq.search.model.k {
    public String X;
    protected List<b> Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f445883a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f445884b0;

    /* renamed from: c0, reason: collision with root package name */
    protected CharSequence f445885c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f445886d0;

    /* renamed from: e0, reason: collision with root package name */
    protected CharSequence f445887e0;

    /* renamed from: f0, reason: collision with root package name */
    protected List<String> f445888f0;

    /* renamed from: g0, reason: collision with root package name */
    protected List<String> f445889g0;

    /* renamed from: h0, reason: collision with root package name */
    protected Set<b> f445890h0;

    /* renamed from: i0, reason: collision with root package name */
    protected TroopInfo f445891i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f445892j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f445893k0;

    /* renamed from: l0, reason: collision with root package name */
    private final List<com.tencent.mobileqq.search.business.contact.entity.e> f445894l0;

    /* renamed from: m0, reason: collision with root package name */
    private final List<com.tencent.mobileqq.search.business.contact.entity.e> f445895m0;

    /* renamed from: n0, reason: collision with root package name */
    private long f445896n0;

    /* renamed from: o0, reason: collision with root package name */
    private long f445897o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f445898a;

        /* renamed from: b, reason: collision with root package name */
        String f445899b;

        /* renamed from: c, reason: collision with root package name */
        b f445900c;

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f445901a;

        /* renamed from: b, reason: collision with root package name */
        public String f445902b;

        /* renamed from: c, reason: collision with root package name */
        public String f445903c;

        /* renamed from: d, reason: collision with root package name */
        public String f445904d;

        /* renamed from: e, reason: collision with root package name */
        public long f445905e = Long.MIN_VALUE;

        /* renamed from: f, reason: collision with root package name */
        public int f445906f;

        /* renamed from: g, reason: collision with root package name */
        public int f445907g;

        public b(String str, String str2, String str3, String str4) {
            this.f445903c = str;
            this.f445902b = str2;
            this.f445901a = str3;
            this.f445904d = str4;
        }
    }

    public f(AppInterface appInterface, int i3, String str, List<b> list, long j3) {
        super(appInterface, i3, 0L);
        this.f445892j0 = false;
        this.f445893k0 = false;
        this.f445894l0 = new LinkedList();
        this.f445895m0 = new LinkedList();
        this.f445896n0 = 0L;
        this.f445897o0 = com.tencent.mobileqq.search.j.f283413b0;
        this.X = str;
        this.Y = list;
        this.f445896n0 = j3;
        this.f445891i0 = SearchUtils.w0(appInterface, str);
        if (((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().isUinInRecent(str)) {
            this.f445892j0 = true;
            if (this.f445891i0.isNewTroop()) {
                this.f445897o0 = com.tencent.mobileqq.search.j.S;
            } else {
                this.f445897o0 = com.tencent.mobileqq.search.j.f283414c0;
            }
        }
        C(7);
        D(this.X);
    }

    static boolean S(int i3, List<List<a>> list, long[] jArr, Map<b, Long> map, int[] iArr, Map<b, Integer> map2, boolean[] zArr, Set<b> set, Map<b, Long> map3) {
        int i16;
        b bVar;
        zArr[i3] = true;
        int i17 = 0;
        while (i17 < list.get(i3).size()) {
            b bVar2 = list.get(i3).get(i17).f445900c;
            if (set.contains(bVar2)) {
                i16 = i17;
            } else {
                long longValue = (jArr[i3] + map.get(bVar2).longValue()) - list.get(i3).get(i17).f445898a;
                if (longValue == 0) {
                    set.add(bVar2);
                    int intValue = map2.get(bVar2).intValue();
                    if (intValue != -1) {
                        bVar = bVar2;
                        i16 = i17;
                        if (S(intValue, list, jArr, map, iArr, map2, zArr, set, map3)) {
                        }
                    } else {
                        bVar = bVar2;
                        i16 = i17;
                    }
                    map2.put(bVar, Integer.valueOf(i3));
                    iArr[i3] = i16;
                    return true;
                }
                i16 = i17;
                if (longValue < map3.get(bVar2).longValue()) {
                    map3.put(bVar2, Long.valueOf(longValue));
                }
            }
            i17 = i16 + 1;
        }
        return false;
    }

    private long U(RecentUserProxy recentUserProxy, String str, long j3, String str2) {
        int i3 = SearchConfig.sReduceDiscussionWeight;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                return SearchUtils.l0(str2, str, j3, false, false, true);
            }
            if (recentUserProxy.isUinInRecent(this.X)) {
                return SearchUtils.l0(str2, str, j3, false, false, false);
            }
            return SearchUtils.l0(str2, str, j3, false, false, true);
        }
        return SearchUtils.l0(str2, str, j3, false, false, !this.f445891i0.isNewTroop());
    }

    private void W() {
        TroopInfo troopInfo;
        if (!y.a() || (troopInfo = this.f445891i0) == null) {
            return;
        }
        if (troopInfo.isNewTroop() && !troopInfo.hasSetTroopName()) {
            this.f445885c0 = getTitle();
        } else {
            this.f445885c0 = super.getTitle();
        }
        this.f445886d0 = troopInfo.wMemberNum + "\u4eba";
    }

    private Object[] Y(b bVar, String str) {
        long j3;
        String str2;
        long j16;
        long j17;
        long j18;
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.G.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (this.f445891i0.isNewTroop()) {
            j3 = com.tencent.mobileqq.search.j.f283426n;
        } else {
            j3 = com.tencent.mobileqq.search.j.f283423k;
        }
        long U = U(recentUserCache, bVar.f445904d, j3, str);
        if (U > Long.MIN_VALUE) {
            String str3 = bVar.f445904d;
            bVar.f445906f = 99;
            j16 = U;
            str2 = str3;
        } else {
            str2 = null;
            j16 = Long.MIN_VALUE;
        }
        if (j16 == Long.MIN_VALUE) {
            if (this.f445891i0.isNewTroop()) {
                j18 = com.tencent.mobileqq.search.j.f283425m;
            } else {
                j18 = com.tencent.mobileqq.search.j.f283434v;
            }
            long U2 = U(recentUserCache, bVar.f445903c, j18, str);
            if (U2 > j16) {
                str2 = bVar.f445903c;
                bVar.f445906f = 66;
                j16 = U2;
            }
        }
        if (j16 == Long.MIN_VALUE) {
            if (this.f445891i0.isNewTroop()) {
                j17 = com.tencent.mobileqq.search.j.f283424l;
            } else {
                j17 = com.tencent.mobileqq.search.j.f283429q;
            }
            long U3 = U(recentUserCache, bVar.f445902b, j17, str);
            if (U3 > j16) {
                str2 = bVar.f445902b;
                bVar.f445906f = 88;
                j16 = U3;
            }
        }
        QLog.d("ContactSearchModelGlobalTroop", 4, "matchMember mMatchType=" + bVar.f445906f, "[mMemberUin=", bVar.f445901a, " mMemberName=", bVar.f445902b, " mMemberNick=", bVar.f445904d, " mMemberCard=", bVar.f445903c, "]");
        return new Object[]{Long.valueOf(j16), str2};
    }

    private long Z(String str) {
        String[] split = str.split("\\s+");
        if (split == null || split.length < 2) {
            return Long.MIN_VALUE;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < split.length; i3++) {
            this.f445889g0.add(split[i3]);
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(arrayList2);
            for (int i16 = 0; i16 < this.Y.size(); i16++) {
                b bVar = this.Y.get(i16);
                Object[] Y = Y(bVar, split[i3]);
                long longValue = ((Long) Y[0]).longValue();
                long j3 = bVar.f445905e;
                if (j3 == Long.MIN_VALUE || longValue > j3) {
                    bVar.f445905e = longValue;
                    bVar.f445907g = bVar.f445906f;
                }
                if (longValue != Long.MIN_VALUE) {
                    a aVar = new a();
                    aVar.f445898a = longValue;
                    aVar.f445899b = (String) Y[1];
                    aVar.f445900c = this.Y.get(i16);
                    arrayList2.add(aVar);
                }
            }
            if (arrayList2.isEmpty()) {
                return Long.MIN_VALUE;
            }
        }
        return a0(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0177, code lost:
    
        r8 = r15 + 1;
        r9 = r0 ? 1 : 0;
        r15 = r24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long a0(List<List<a>> list) {
        long j3;
        long[] jArr = new long[list.size()];
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int[] iArr = new int[list.size()];
        HashMap hashMap3 = new HashMap();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            j3 = Long.MIN_VALUE;
            if (i3 >= list.size()) {
                break;
            }
            for (int i16 = 0; i16 < list.get(i3).size(); i16++) {
                b bVar = list.get(i3).get(i16).f445900c;
                if (!hashMap3.containsKey(bVar)) {
                    hashMap3.put(bVar, -1);
                    hashMap.put(bVar, 0L);
                }
                if (list.get(i3).get(i16).f445898a > j3) {
                    j3 = list.get(i3).get(i16).f445898a;
                }
            }
            jArr[i3] = j3;
            i3++;
        }
        int i17 = 0;
        loop2: while (i17 < list.size()) {
            boolean[] zArr = new boolean[list.size()];
            Arrays.fill(zArr, z16);
            HashSet hashSet = new HashSet();
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                hashMap2.put((b) it.next(), Long.MAX_VALUE);
            }
            while (true) {
                HashSet hashSet2 = hashSet;
                HashMap hashMap4 = hashMap3;
                boolean[] zArr2 = zArr;
                HashMap hashMap5 = hashMap3;
                int i18 = i17;
                boolean z17 = z16;
                if (!S(i17, list, jArr, hashMap, iArr, hashMap4, zArr, hashSet2, hashMap2)) {
                    long j16 = Long.MAX_VALUE;
                    for (b bVar2 : hashMap2.keySet()) {
                        HashSet hashSet3 = hashSet2;
                        if (!hashSet3.contains(bVar2)) {
                            long longValue = ((Long) hashMap2.get(bVar2)).longValue();
                            if (longValue < j16) {
                                j16 = longValue;
                            }
                        }
                        hashSet2 = hashSet3;
                    }
                    HashSet hashSet4 = hashSet2;
                    if (j16 == Long.MAX_VALUE || j16 == 0) {
                        break loop2;
                    }
                    int i19 = z17 ? 1 : 0;
                    while (i19 <= i18) {
                        boolean[] zArr3 = zArr2;
                        if (zArr3[i19]) {
                            jArr[i19] = jArr[i19] - j16;
                        }
                        i19++;
                        zArr2 = zArr3;
                    }
                    boolean[] zArr4 = zArr2;
                    for (b bVar3 : hashMap.keySet()) {
                        if (!hashSet4.contains(bVar3)) {
                            hashMap2.put(bVar3, Long.valueOf(((Long) hashMap2.get(bVar3)).longValue() - j16));
                        } else {
                            hashMap.put(bVar3, Long.valueOf(((Long) hashMap.get(bVar3)).longValue() + j16));
                        }
                    }
                    hashSet4.clear();
                    Arrays.fill(zArr4, z17);
                    z16 = z17 ? 1 : 0;
                    zArr = zArr4;
                    hashSet = hashSet4;
                    i17 = i18;
                    hashMap3 = hashMap5;
                }
            }
            return Long.MIN_VALUE;
        }
        for (?? r95 = z16; r95 < list.size(); r95++) {
            long j17 = list.get(r95).get(iArr[r95]).f445898a;
            if (j17 > j3) {
                j3 = j17;
            }
            b bVar4 = list.get(r95).get(iArr[r95]).f445900c;
            String str = list.get(r95).get(iArr[r95]).f445899b;
            this.f445890h0.add(bVar4);
            this.f445888f0.add(str);
            R(str, bVar4, true, this.f445895m0);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        String str;
        List<com.tencent.mobileqq.search.business.contact.entity.e> list;
        com.tencent.mobileqq.search.business.contact.entity.d dVar = new com.tencent.mobileqq.search.business.contact.entity.d();
        dVar.f282931a = this.f445892j0;
        dVar.f282932b = this.f445891i0.isNewTroop();
        boolean z16 = this.f445893k0;
        if (z16) {
            str = "TroopMulti";
        } else {
            str = "Troop";
        }
        if (z16) {
            list = this.f445895m0;
        } else {
            list = this.f445894l0;
        }
        return am.b(list, this.f445896n0, dVar, str);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 2;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public long J() {
        return super.J();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        if (y.a()) {
            return this.f445886d0;
        }
        return this.X;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        if (this.f445891i0 != null && y.a()) {
            return this.f445891i0.getTroopDisplayName();
        }
        return ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getRealTroopName(this.G, this.X, true);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        SearchUtils.b T0;
        this.f445888f0 = new ArrayList();
        this.f445889g0 = new ArrayList();
        this.f445890h0 = new HashSet();
        this.f445884b0 = str;
        this.Z = Long.MIN_VALUE;
        if (y.a() && (T0 = SearchUtils.T0(this.N, this.f445891i0, str)) != null) {
            this.f445883a0 = T0.f284970b;
            this.Z = T0.f284969a;
        }
        if (this.Z == Long.MIN_VALUE) {
            b bVar = null;
            long j3 = Long.MIN_VALUE;
            String str2 = null;
            for (int i3 = 0; i3 < this.Y.size(); i3++) {
                Object[] Y = Y(this.Y.get(i3), str);
                long longValue = ((Long) Y[0]).longValue();
                if (longValue > j3) {
                    bVar = this.Y.get(i3);
                    str2 = (String) Y[1];
                    j3 = longValue;
                }
            }
            if (bVar != null) {
                R(str2, bVar, false, this.f445894l0);
                this.f445890h0.add(bVar);
                this.f445888f0.add(str2);
                this.f445889g0.add(str);
            }
            if (j3 > this.Z) {
                this.Z = j3;
            }
        }
        if (this.Z == Long.MIN_VALUE) {
            long Z = Z(str);
            if (Z > this.Z) {
                this.f445893k0 = true;
                this.Z = Z;
            }
        }
        long j16 = this.Z;
        if (j16 != Long.MIN_VALUE) {
            this.Z = j16 + this.f445897o0;
            V();
            W();
        }
        return this.Z;
    }

    public void R(String str, b bVar, boolean z16, List<com.tencent.mobileqq.search.business.contact.entity.e> list) {
        int i3;
        if (str != null && bVar != null) {
            com.tencent.mobileqq.search.business.contact.entity.e eVar = new com.tencent.mobileqq.search.business.contact.entity.e();
            eVar.f282934b = str;
            if (z16) {
                i3 = bVar.f445907g;
            } else {
                i3 = bVar.f445906f;
            }
            if (i3 == 66) {
                eVar.f282933a = "memberCard";
            } else if (i3 == 88) {
                eVar.f282933a = "memberNickName";
            } else if (i3 == 99) {
                eVar.f282933a = "memberFriNick";
            } else {
                eVar.f282933a = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            list.add(eVar);
        }
    }

    public TroopInfo T() {
        return this.f445891i0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        String str;
        if (this.f445883a0 != 0 && y.a()) {
            this.f445887e0 = SearchUtils.V(this.f445891i0, this.f445884b0, this.f445883a0);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.Y != null) {
            spannableStringBuilder.append((CharSequence) "\u5305\u542b\uff1a");
            int size = this.f445888f0.size() - 1;
            int i16 = 0;
            while (true) {
                if (size >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i16 < 10) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 || !z17) {
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
                b bVar = this.Y.get(i17);
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
                        spannableStringBuilder.append(SearchUtils.E(str, this.f445889g0.get(0), 6, false));
                        spannableStringBuilder.append((CharSequence) "\u3001");
                    }
                }
                i17++;
            }
            if (spannableStringBuilder.length() == 3) {
                spannableStringBuilder.clear();
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\u3001') {
            this.f445887e0 = spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1);
        } else {
            this.f445887e0 = spannableStringBuilder;
        }
    }

    public boolean X(String str) {
        TroopInfo troopInfo = this.f445891i0;
        if (troopInfo == null) {
            return false;
        }
        return troopInfo.isOwner();
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return this.f445887e0;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.f445884b0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        if (this.f445891i0.isNewTroop() && !this.f445891i0.hasSetTroopName()) {
            return getTitle();
        }
        return super.getTitle();
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            String troopName = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.G, this.X, true);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterChatWin(view.getContext(), this.G, this.X, 1, troopName, false);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445884b0);
            SearchUtils.f1(this.G, getTitle().toString(), this.X, "", 1);
            SearchUtils.c1(this.f445884b0, 20, 2, view);
            SearchUtils.Z0(this.f445884b0, 20, view, false);
            SearchUtils.X0(this, view);
            if ((G() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445884b0, this.L, (String) G(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 2, 0, null, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D3B", 0, 0, null, null);
                }
            }
        }
        if (SearchConfig.needSeparate) {
            SearchUtils.V0("search", VipFunCallConstants.KEY_GROUP, "groups", 0, 0, SearchUtils.b0(this.I));
        }
    }
}
