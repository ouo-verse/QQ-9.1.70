package wn2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.q {

    /* renamed from: f0, reason: collision with root package name */
    private static LruCache<String, String> f445952f0 = new LruCache<>(3);
    public PhoneContact X;
    private long Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445953a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445954b0;

    /* renamed from: c0, reason: collision with root package name */
    public ChnToSpell.b f445955c0;

    /* renamed from: d0, reason: collision with root package name */
    public ChnToSpell.b f445956d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f445957e0;

    public m(AppInterface appInterface, int i3, PhoneContact phoneContact) {
        super(appInterface, i3, 0L);
        this.Z = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        this.f445957e0 = com.tencent.mobileqq.search.j.Q;
        this.X = phoneContact;
        if (TextUtils.isEmpty(phoneContact.uin)) {
            this.f445957e0 = com.tencent.mobileqq.search.j.Y;
        }
        if (!TextUtils.isEmpty(phoneContact.name)) {
            this.f445955c0 = ChnToSpell.e(phoneContact.name, 1);
            this.f445956d0 = ChnToSpell.e(phoneContact.name, 2);
        }
        C(6);
        D(String.valueOf(G()));
    }

    private boolean S(String str, boolean z16) {
        return ((IAddFriendServiceApi) this.G.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, z16, false);
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        return am.a(this.f445953a0, this.J, this.Z, this.Y, null, "PhoneContact", 0L);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        String str = this.X.uin;
        if (TextUtils.isEmpty(str)) {
            return "mn:" + this.X.mobileNo;
        }
        if (str.equals("0")) {
            return this.X.unifiedCode;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        if (this.I == 17) {
            return null;
        }
        return this.X.mobileNo;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.X.name;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        if (TextUtils.isEmpty(this.X.uin)) {
            return AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT;
        }
        if (this.X.uin.equals("0")) {
            return 1006;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.f445954b0 = str;
        this.Y = Long.MIN_VALUE;
        long m06 = SearchUtils.m0(str, this.X.name, this.f445955c0, this.f445956d0, com.tencent.mobileqq.search.j.f283430r);
        if (m06 > this.Y) {
            this.Y = m06;
            this.Z = "name";
            this.f445953a0 = this.X.name;
        }
        String str2 = f445952f0.get(str);
        if (str2 == null) {
            str2 = str.replaceAll("-", "");
            f445952f0.put(str, str2);
        }
        long k06 = SearchUtils.k0(str2, this.X.mobileNo, com.tencent.mobileqq.search.j.f283433u, true);
        if (k06 > this.Y) {
            this.Y = k06;
            this.Z = "mobileNo";
            this.f445953a0 = this.X.mobileNo;
        }
        long j3 = this.Y;
        if (j3 != Long.MIN_VALUE) {
            this.Y = j3 + this.f445957e0;
        }
        return this.Y;
    }

    public String R() {
        return this.X.unifiedCode;
    }

    @Override // com.tencent.mobileqq.search.model.q
    public PhoneContact b() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        if (!TextUtils.isEmpty(this.X.uin) && !this.X.uin.equals("0")) {
            return 1;
        }
        return 11;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    public String l() {
        String str = this.X.uin;
        if (TextUtils.isEmpty(str)) {
            return this.X.mobileNo;
        }
        if (str.equals("0")) {
            return this.X.unifiedCode;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence m() {
        if (SearchUtils.F0(this.I)) {
            return HardCodeUtil.qqStr(R.string.l2q);
        }
        int i3 = this.I;
        if (i3 != 17 && i3 != 19) {
            return HardCodeUtil.qqStr(R.string.l3r);
        }
        if (!TextUtils.isEmpty(this.X.uin) && !this.X.uin.equalsIgnoreCase("0")) {
            return HardCodeUtil.qqStr(R.string.l3a);
        }
        if (S(this.X.unifiedCode, true)) {
            return HardCodeUtil.qqStr(R.string.l3y);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        if (this.I == 17 && this.X.samFriend > 0) {
            return String.format(this.G.getApplication().getResources().getString(R.string.a9n), Integer.valueOf(this.X.samFriend));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.f445954b0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        if (this.I == 17) {
            String K = K();
            if (!TextUtils.isEmpty(K)) {
                if (!K.equals(this.U) || !TextUtils.equals(this.S, getKeyword())) {
                    this.U = K;
                    this.S = getKeyword();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.qqStr(R.string.l2w));
                    spannableStringBuilder.append(SearchUtils.D(K, getKeyword(), 10));
                    this.Q = spannableStringBuilder;
                }
                return this.Q;
            }
            this.U = null;
            return null;
        }
        return super.getSubTitleSpans();
    }

    @NonNull
    public String toString() {
        return "ContactSearchModelPhoneContact{name=" + getTitle() + ", uin=" + l() + "}";
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x02f3  */
    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(View view) {
        int i3;
        String str;
        AllInOne allInOne;
        int i16;
        super.v(view);
        int i17 = 1;
        if (view.getId() == R.id.i8s && this.I == 17) {
            if (!((IPhoneContactService) this.G.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                ReportController.o(this.G, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
                ReportController.o(this.G, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
                i16 = 3075;
            } else {
                ReportController.o(this.G, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
                ReportController.o(this.G, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
                i16 = 3006;
                i17 = 13;
            }
            IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
            Context context = view.getContext();
            PhoneContact phoneContact = this.X;
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(view.getContext(), iAddFriendApi.startAddFriend(context, 2, phoneContact.unifiedCode, null, i16, i17, phoneContact.name, null, null, HardCodeUtil.qqStr(R.string.l3u), null));
        } else {
            int i18 = this.I;
            int i19 = AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND;
            if (i18 == 17) {
                PhoneContact phoneContact2 = this.X;
                IPhoneContactService iPhoneContactService = (IPhoneContactService) this.G.getRuntimeService(IPhoneContactService.class, "");
                if (!TextUtils.isEmpty(phoneContact2.uin) && !"0".equals(phoneContact2.uin)) {
                    str = phoneContact2.unifiedCode;
                    allInOne = new AllInOne(str, 53);
                    i19 = AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND;
                } else if ("0".equals(phoneContact2.uin)) {
                    String str2 = this.X.unifiedCode;
                    if (iPhoneContactService.isBindedIgnoreUpload()) {
                        allInOne = new AllInOne(str2, 53);
                        i19 = AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND;
                    } else {
                        allInOne = new AllInOne(str2, 29);
                    }
                    str = str2;
                } else {
                    str = this.X.mobileNo;
                    allInOne = new AllInOne(str, 53);
                    i19 = 56942;
                }
                String str3 = phoneContact2.name;
                allInOne.contactName = str3;
                allInOne.nickname = str3;
                allInOne.profileEntryType = 103;
                ProfileUtils.openProfileCard(view.getContext(), allInOne);
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                SearchUtils.f1(this.G, getTitleSpans().toString(), str, "", i19);
            } else if (SearchUtils.F0(i18)) {
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
                String str4 = this.X.uin;
                if (!((IPhoneContactService) this.G.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                    if ("0".equals(this.X.uin)) {
                        String str5 = this.X.unifiedCode;
                        AllInOne allInOne2 = new AllInOne(str5, 29);
                        allInOne2.contactArray = new ArrayList<>();
                        PhoneContact phoneContact3 = this.X;
                        allInOne2.contactName = phoneContact3.name;
                        allInOne2.nickname = phoneContact3.nickName;
                        allInOne2.chatAbility = phoneContact3.ability;
                        allInOne2.lastActivity = 3;
                        allInOne2.profileEntryType = 103;
                        ProfileUtils.openProfileCard(view.getContext(), allInOne2);
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                        SearchUtils.f1(this.G, getTitleSpans().toString(), str5, "", AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND);
                        return;
                    }
                    if (TextUtils.isEmpty(this.X.uin)) {
                        String str6 = this.X.mobileNo;
                        AllInOne allInOne3 = new AllInOne(str6, 53);
                        allInOne3.contactArray = new ArrayList<>();
                        PhoneContact phoneContact4 = this.X;
                        allInOne3.contactName = phoneContact4.name;
                        allInOne3.nickname = phoneContact4.nickName;
                        allInOne3.chatAbility = phoneContact4.ability;
                        allInOne3.lastActivity = 3;
                        allInOne3.profileEntryType = 103;
                        ProfileUtils.openProfileCard(view.getContext(), allInOne3);
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                        SearchUtils.f1(this.G, getTitleSpans().toString(), str6, "", AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND);
                        return;
                    }
                } else {
                    if (TextUtils.isEmpty(this.X.uin)) {
                        String str7 = this.X.mobileNo;
                        AllInOne allInOne4 = new AllInOne(str7, 53);
                        allInOne4.contactArray = new ArrayList<>();
                        PhoneContact phoneContact5 = this.X;
                        allInOne4.contactName = phoneContact5.name;
                        allInOne4.nickname = phoneContact5.nickName;
                        allInOne4.chatAbility = phoneContact5.ability;
                        allInOne4.lastActivity = 3;
                        allInOne4.profileEntryType = 103;
                        ProfileUtils.openProfileCard(view.getContext(), allInOne4);
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                        SearchUtils.f1(this.G, getTitleSpans().toString(), str7, "", AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND);
                        return;
                    }
                    if ("0".equals(this.X.uin)) {
                        str4 = this.X.unifiedCode;
                        i3 = 1006;
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterChatWin(view.getContext(), this.G, str4, i3, this.X.name, false);
                        SearchUtils.c1(this.f445954b0, 20, 1, view);
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                        SearchUtils.f1(this.G, getTitleSpans().toString(), str4, "", i3);
                        SearchUtils.Z0(this.f445954b0, 20, view, false);
                        SearchUtils.X0(this, view);
                        if (SearchConfig.needSeparate) {
                            SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
                        }
                    }
                }
                i3 = 0;
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterChatWin(view.getContext(), this.G, str4, i3, this.X.name, false);
                SearchUtils.c1(this.f445954b0, 20, 1, view);
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445954b0);
                SearchUtils.f1(this.G, getTitleSpans().toString(), str4, "", i3);
                SearchUtils.Z0(this.f445954b0, 20, view, false);
                SearchUtils.X0(this, view);
                if (SearchConfig.needSeparate) {
                }
            } else {
                SearchUtils.l1(view, this);
            }
        }
        if (SearchUtils.F0(this.I) && (G() instanceof String) && !this.M) {
            SearchUtils.o1(this.G, this.f445954b0, this.L, (String) G(), H());
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            String str8 = this.L;
            if (str8 != null && !TextUtils.isEmpty(str8)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 1, 0, null, null);
            } else {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
            }
        }
    }
}
