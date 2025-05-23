package wn2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends r {

    /* renamed from: f0, reason: collision with root package name */
    TroopMemberInfo f445986f0;

    /* renamed from: g0, reason: collision with root package name */
    String f445987g0;

    public s(AppInterface appInterface, int i3, TroopMemberInfo troopMemberInfo, String str) {
        super(appInterface, i3, troopMemberInfo);
        this.f445986f0 = troopMemberInfo;
        this.f445987g0 = str;
    }

    @Override // wn2.r, com.tencent.mobileqq.search.model.k
    public String K() {
        if (this.f445986f0.noCommonFrdCnt()) {
            return "";
        }
        return this.f445986f0.getCommonFrdCnt() + HardCodeUtil.qqStr(R.string.ucr);
    }

    @Override // wn2.r, com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445986f0.nickInfo.getShowName();
    }

    public int T() {
        if (this.f445986f0.noCommonFrdCnt()) {
            return 0;
        }
        return this.f445986f0.getCommonFrdCnt();
    }

    @Override // wn2.r, com.tencent.mobileqq.search.model.y
    public CharSequence m() {
        if (SearchUtils.E0(this.G, this.f445986f0.memberuin)) {
            return HardCodeUtil.qqStr(R.string.ucp);
        }
        if (SearchUtils.B0(this.G, this.f445986f0.memberuin, false)) {
            return HardCodeUtil.qqStr(R.string.ucq);
        }
        return null;
    }

    @Override // wn2.r, com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // wn2.r, com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Context context = view.getContext();
        if (view.getId() == R.id.i8s && this.I == 23) {
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).addFriend(context, this.f445986f0, this.f445987g0, false);
            return;
        }
        if (this.I == 23) {
            Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(context, null);
            profileCardIntentOnly.putExtra("troopUin", this.f445986f0.troopuin);
            profileCardIntentOnly.putExtra("memberUin", this.f445986f0.memberuin);
            profileCardIntentOnly.putExtra("fromFlag", 1);
            profileCardIntentOnly.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, view.getContext().getString(R.string.i7y));
            profileCardIntentOnly.putExtra("custom_leftbackbutton_name", view.getContext().getString(R.string.button_back));
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).joinFriendProfileIntentWithTroopMemberCardIntent(context, this.G, profileCardIntentOnly, 9);
        }
    }
}
