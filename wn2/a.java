package wn2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.l {
    private DiscussionInfo X;
    private List<DiscussionMemberInfo> Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445844a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<String> f445845b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<String> f445846c0;

    /* renamed from: d0, reason: collision with root package name */
    private Set<DiscussionMemberInfo> f445847d0;

    /* renamed from: e0, reason: collision with root package name */
    private CharSequence f445848e0;

    /* renamed from: f0, reason: collision with root package name */
    private CharSequence f445849f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f445850g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f445851h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f445852i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f445853j0;

    /* renamed from: k0, reason: collision with root package name */
    private final List<com.tencent.mobileqq.search.business.contact.entity.e> f445854k0;

    /* renamed from: l0, reason: collision with root package name */
    private final List<com.tencent.mobileqq.search.business.contact.entity.e> f445855l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f445856m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: wn2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C11497a {

        /* renamed from: a, reason: collision with root package name */
        long f445857a;

        /* renamed from: b, reason: collision with root package name */
        String f445858b;

        /* renamed from: c, reason: collision with root package name */
        DiscussionMemberInfo f445859c;

        C11497a() {
        }
    }

    public a(AppInterface appInterface, int i3, DiscussionInfo discussionInfo, List<DiscussionMemberInfo> list, int i16) {
        super(appInterface, i3, i16);
        this.f445850g0 = com.tencent.mobileqq.search.j.T;
        this.f445851h0 = false;
        this.f445853j0 = false;
        this.f445854k0 = new LinkedList();
        this.f445855l0 = new LinkedList();
        this.f445856m0 = false;
        this.X = discussionInfo;
        this.Y = list == null ? new ArrayList<>() : list;
        this.f445851h0 = !discussionInfo.hasRenamed();
        this.f445852i0 = appInterface.getCurrentAccountUin();
        C(7);
        D(discussionInfo.uin);
    }

    private void R(String str, String str2, List<com.tencent.mobileqq.search.business.contact.entity.e> list) {
        if (str != null && str2 != null) {
            com.tencent.mobileqq.search.business.contact.entity.e eVar = new com.tencent.mobileqq.search.business.contact.entity.e();
            eVar.f282934b = str;
            eVar.f282933a = str2;
            list.add(eVar);
        }
    }

    static boolean S(int i3, List<List<C11497a>> list, long[] jArr, Map<DiscussionMemberInfo, Long> map, int[] iArr, Map<DiscussionMemberInfo, Integer> map2, boolean[] zArr, Set<DiscussionMemberInfo> set, Map<DiscussionMemberInfo, Long> map3) {
        int i16;
        DiscussionMemberInfo discussionMemberInfo;
        zArr[i3] = true;
        int i17 = 0;
        while (i17 < list.get(i3).size()) {
            DiscussionMemberInfo discussionMemberInfo2 = list.get(i3).get(i17).f445859c;
            if (set.contains(discussionMemberInfo2)) {
                i16 = i17;
            } else {
                long longValue = (jArr[i3] + map.get(discussionMemberInfo2).longValue()) - list.get(i3).get(i17).f445857a;
                if (longValue == 0) {
                    set.add(discussionMemberInfo2);
                    int intValue = map2.get(discussionMemberInfo2).intValue();
                    if (intValue != -1) {
                        discussionMemberInfo = discussionMemberInfo2;
                        i16 = i17;
                        if (S(intValue, list, jArr, map, iArr, map2, zArr, set, map3)) {
                        }
                    } else {
                        discussionMemberInfo = discussionMemberInfo2;
                        i16 = i17;
                    }
                    map2.put(discussionMemberInfo, Integer.valueOf(i3));
                    iArr[i3] = i16;
                    return true;
                }
                i16 = i17;
                if (longValue < map3.get(discussionMemberInfo2).longValue()) {
                    map3.put(discussionMemberInfo2, Long.valueOf(longValue));
                }
            }
            i17 = i16 + 1;
        }
        return false;
    }

    private com.tencent.qqnt.ntrelation.friendsinfo.bean.d T(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), com.tencent.mobileqq.search.model.k.W);
    }

    private long V(RecentUserProxy recentUserProxy, String str, long j3, String str2) {
        int i3 = SearchConfig.sReduceDiscussionWeight;
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                return SearchUtils.n0(str2, str, j3);
            }
            if (recentUserProxy.isUinInRecent(this.X.uin)) {
                return U(str2, str, j3);
            }
            return SearchUtils.n0(str2, str, j3);
        }
        return SearchUtils.n0(str2, str, j3);
    }

    private void W() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3 = 0;
        if (!SearchUtils.F0(this.I) && this.I != 5) {
            this.f445848e0 = HardCodeUtil.qqStr(R.string.f171809l42);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!this.X.hasRenamed()) {
                spannableStringBuilder.append((CharSequence) "(");
                List<DiscussionMemberInfo> list = this.Y;
                if (list != null) {
                    i3 = list.size();
                }
                spannableStringBuilder.append((CharSequence) String.valueOf(i3));
                spannableStringBuilder.append((CharSequence) ")");
            } else if (!this.f445845b0.isEmpty()) {
                spannableStringBuilder.append((CharSequence) "(");
                for (int size = this.f445845b0.size() - 1; size >= 0; size--) {
                    spannableStringBuilder.append(SearchUtils.D(this.f445845b0.get(size), this.f445846c0.get(size), 6));
                    if (size > 0) {
                        spannableStringBuilder.append((CharSequence) "\u3001");
                    }
                }
                spannableStringBuilder.append((CharSequence) ")");
            }
            this.f445849f0 = spannableStringBuilder;
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (this.Y != null) {
            spannableStringBuilder2.append((CharSequence) "\u5305\u542b\uff1a");
            int size2 = this.f445845b0.size() - 1;
            int i16 = 0;
            while (true) {
                if (size2 >= 0) {
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
                spannableStringBuilder2.append(SearchUtils.D(this.f445845b0.get(size2), this.f445846c0.get(size2), 6));
                i16++;
                if (i16 < this.Y.size()) {
                    spannableStringBuilder2.append((CharSequence) "\u3001");
                }
                size2--;
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
                DiscussionMemberInfo discussionMemberInfo = this.Y.get(i17);
                if (!this.f445847d0.contains(discussionMemberInfo)) {
                    String str = discussionMemberInfo.inteRemark;
                    if (str == null) {
                        str = discussionMemberInfo.memberName;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        i16++;
                        spannableStringBuilder2.append((CharSequence) str);
                        if (i16 < this.Y.size()) {
                            spannableStringBuilder2.append((CharSequence) "\u3001");
                        }
                    }
                }
                i17++;
            }
            if (spannableStringBuilder2.length() == 3) {
                spannableStringBuilder2.clear();
            }
        }
        this.f445848e0 = spannableStringBuilder2;
        List<DiscussionMemberInfo> list2 = this.Y;
        if (list2 != null && !list2.isEmpty()) {
            this.f445849f0 = "(" + this.Y.size() + HardCodeUtil.qqStr(R.string.l2i);
            return;
        }
        this.f445849f0 = null;
    }

    private Object[] X(DiscussionMemberInfo discussionMemberInfo, String str) {
        String str2;
        long j3;
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.G.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        long V = V(recentUserCache, discussionMemberInfo.inteRemark, com.tencent.mobileqq.search.j.f283428p, str);
        if (V > Long.MIN_VALUE) {
            j3 = V;
            str2 = discussionMemberInfo.inteRemark;
        } else {
            str2 = null;
            j3 = Long.MIN_VALUE;
        }
        long V2 = V(recentUserCache, discussionMemberInfo.memberName, com.tencent.mobileqq.search.j.f283429q, str);
        if (V2 > j3) {
            str2 = discussionMemberInfo.memberName;
            j3 = V2;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d T = T(discussionMemberInfo.memberUin);
        if (T != null && T.B()) {
            long V3 = V(recentUserCache, T.r(), com.tencent.mobileqq.search.j.f283427o, str);
            if (V3 > j3) {
                str2 = T.r();
                j3 = V3;
            }
            long V4 = V(recentUserCache, T.p(), com.tencent.mobileqq.search.j.f283429q, str);
            if (V4 > j3) {
                str2 = T.p();
                j3 = V4;
            }
        }
        return new Object[]{Long.valueOf(j3), str2};
    }

    private long Y(String str) {
        String[] split = str.split("\\s+");
        if (split == null || split.length < 2) {
            return Long.MIN_VALUE;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < split.length; i3++) {
            this.f445846c0.add(split[i3]);
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(arrayList2);
            for (int i16 = 0; i16 < this.Y.size(); i16++) {
                if (!this.Y.get(i16).memberUin.equals(this.f445852i0)) {
                    Object[] X = X(this.Y.get(i16), split[i3]);
                    long longValue = ((Long) X[0]).longValue();
                    if (longValue != Long.MIN_VALUE) {
                        C11497a c11497a = new C11497a();
                        c11497a.f445857a = longValue;
                        c11497a.f445858b = (String) X[1];
                        c11497a.f445859c = this.Y.get(i16);
                        arrayList2.add(c11497a);
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return Long.MIN_VALUE;
            }
        }
        return Z(arrayList);
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
    private long Z(List<List<C11497a>> list) {
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
                DiscussionMemberInfo discussionMemberInfo = list.get(i3).get(i16).f445859c;
                if (!hashMap3.containsKey(discussionMemberInfo)) {
                    hashMap3.put(discussionMemberInfo, -1);
                    hashMap.put(discussionMemberInfo, 0L);
                }
                if (list.get(i3).get(i16).f445857a > j3) {
                    j3 = list.get(i3).get(i16).f445857a;
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
                hashMap2.put((DiscussionMemberInfo) it.next(), Long.MAX_VALUE);
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
                    for (DiscussionMemberInfo discussionMemberInfo2 : hashMap2.keySet()) {
                        HashSet hashSet3 = hashSet2;
                        if (!hashSet3.contains(discussionMemberInfo2)) {
                            long longValue = ((Long) hashMap2.get(discussionMemberInfo2)).longValue();
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
                    for (DiscussionMemberInfo discussionMemberInfo3 : hashMap.keySet()) {
                        if (!hashSet4.contains(discussionMemberInfo3)) {
                            hashMap2.put(discussionMemberInfo3, Long.valueOf(((Long) hashMap2.get(discussionMemberInfo3)).longValue() - j16));
                        } else {
                            hashMap.put(discussionMemberInfo3, Long.valueOf(((Long) hashMap.get(discussionMemberInfo3)).longValue() + j16));
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
            long j17 = list.get(r95).get(iArr[r95]).f445857a;
            if (j17 > j3) {
                j3 = j17;
            }
            String str = list.get(r95).get(iArr[r95]).f445858b;
            this.f445847d0.add(list.get(r95).get(iArr[r95]).f445859c);
            this.f445845b0.add(str);
            R(str, "member", this.f445855l0);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        boolean z16;
        String str;
        List<com.tencent.mobileqq.search.business.contact.entity.e> list;
        com.tencent.mobileqq.search.business.contact.entity.d dVar = new com.tencent.mobileqq.search.business.contact.entity.d();
        long j3 = this.J;
        if (j3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.f282931a = z16;
        boolean z17 = this.f445853j0;
        if (z17) {
            str = "DiscussionMulti";
        } else {
            str = "Discussion";
        }
        if (z17) {
            list = this.f445855l0;
        } else {
            list = this.f445854k0;
        }
        return am.b(list, j3, dVar, str);
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: G */
    public Object getUin() {
        return this.X.uin;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445849f0.toString();
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return SearchUtils.t(MobileQQ.sMobileQQ.getApplicationContext(), this.X);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 3000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0107, code lost:
    
        if (r14 == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0126  */
    @Override // com.tencent.mobileqq.search.model.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected long N(String str) {
        boolean z16;
        long j3;
        boolean z17 = false;
        this.f445856m0 = false;
        this.f445845b0 = new ArrayList();
        this.f445846c0 = new ArrayList();
        this.f445847d0 = new HashSet();
        this.f445844a0 = str;
        this.Z = Long.MIN_VALUE;
        if (!this.f445851h0) {
            long U = U(str, this.X.discussionName, com.tencent.mobileqq.search.j.f283421i);
            if (U > this.Z) {
                this.Z = U;
                R(this.X.discussionName, "name", this.f445854k0);
                this.f445856m0 = true;
            }
        }
        DiscussionMemberInfo discussionMemberInfo = null;
        long j16 = Long.MIN_VALUE;
        String str2 = null;
        for (int i3 = 0; i3 < this.Y.size(); i3++) {
            if (!this.Y.get(i3).memberUin.equals(this.f445852i0)) {
                Object[] X = X(this.Y.get(i3), str);
                long longValue = ((Long) X[0]).longValue();
                if (longValue > j16) {
                    discussionMemberInfo = this.Y.get(i3);
                    str2 = (String) X[1];
                    j16 = longValue;
                }
            }
        }
        if (discussionMemberInfo != null) {
            R(str2, "member", this.f445854k0);
            this.f445847d0.add(discussionMemberInfo);
            this.f445845b0.add(str2);
            this.f445846c0.add(str);
        }
        if (j16 > this.Z) {
            this.Z = j16;
            this.f445856m0 = false;
        }
        if (this.Z == Long.MIN_VALUE) {
            long Y = Y(str);
            if (Y > this.Z) {
                this.Z = Y;
                this.f445856m0 = false;
                this.f445853j0 = true;
            }
        }
        if (this.f445847d0.size() != this.Y.size()) {
            if (this.f445847d0.size() == this.Y.size() - 1) {
                String currentAccountUin = this.G.getCurrentAccountUin();
                Iterator<DiscussionMemberInfo> it = this.f445847d0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        DiscussionMemberInfo next = it.next();
                        if (currentAccountUin != null && currentAccountUin.equals(next.memberUin)) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            this.f445850g0 = com.tencent.mobileqq.search.j.I;
            RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.G.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
            if (!z17) {
                this.f445850g0 = com.tencent.mobileqq.search.j.G;
            } else if (recentUserCache.isUinInRecent(this.X.uin)) {
                if (this.f445856m0) {
                    this.f445850g0 = com.tencent.mobileqq.search.j.I;
                } else {
                    this.f445850g0 = com.tencent.mobileqq.search.j.R;
                }
            } else {
                this.f445850g0 = com.tencent.mobileqq.search.j.T;
            }
            j3 = this.Z;
            if (j3 != Long.MIN_VALUE) {
                this.Z = j3 + this.f445850g0;
                W();
            }
            return this.Z;
        }
        z17 = true;
        this.f445850g0 = com.tencent.mobileqq.search.j.I;
        RecentUserProxy recentUserCache2 = ((IRecentUserProxyService) this.G.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (!z17) {
        }
        j3 = this.Z;
        if (j3 != Long.MIN_VALUE) {
        }
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected boolean P() {
        return this.f445856m0;
    }

    public long U(String str, String str2, long j3) {
        if (this.N) {
            return SearchUtils.o0(str, str2, j3, true, false, false);
        }
        return SearchUtils.j0(str, str2, j3);
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 101;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return this.f445848e0;
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
        return this.f445844a0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return this.f445849f0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.f445851h0) {
            return getTitle();
        }
        return super.getTitleSpans();
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            Context context = view.getContext();
            AppInterface appInterface = this.G;
            DiscussionInfo discussionInfo = this.X;
            iSearchPieceFetcher.enterChatWin(context, appInterface, discussionInfo.uin, 3000, discussionInfo.discussionName, false);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445844a0);
            SearchUtils.f1(this.G, getTitleSpans().toString(), this.X.uin, "", 3000);
            SearchUtils.c1(this.f445844a0, 20, 3, view);
            SearchUtils.Z0(this.f445844a0, 30, view, false);
            SearchUtils.Y0(this.f445844a0);
            SearchUtils.X0(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", VipFunCallConstants.KEY_GROUP, "groups", 0, 0, SearchUtils.b0(this.I));
            }
            if ((getUin() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445844a0, this.L, (String) getUin(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 2, 0, null, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D3B", 0, 0, null, null);
                }
            }
        } else {
            SearchUtils.l1(view, this);
        }
        new rn2.c(this.G).f("dc00899").a("Grp_listNew").d("search_result").c("clk_grp").b(this.X.uin).e();
    }
}
