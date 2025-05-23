package wn2;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.search.model.k {
    private GameFriendSelectorSvr$Friend X;
    private String Y;
    private ChnToSpell.b Z;

    /* renamed from: a0, reason: collision with root package name */
    private ChnToSpell.b f445880a0;

    public d(AppInterface appInterface, int i3, long j3, GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
        super(appInterface, i3, j3);
        ChnToSpell.c f16;
        this.X = gameFriendSelectorSvr$Friend;
        if (QLog.isDevelopLevel()) {
            QLog.d("gameFriInfo.ContactSearchModelGameFriend", 2, "[ContactSearchModelGameFriend]");
        }
        if (this.X == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("gameFriInfo.ContactSearchModelGameFriend", 2, "roleName:" + this.X.role_name.get() + ",avatar:" + this.X.avatar.get() + ",tag:" + this.X.qq_nick);
        }
        String R = R();
        if (QLog.isDevelopLevel()) {
            QLog.d("gameFriInfo.ContactSearchModelGameFriend", 2, "nickname:" + R);
        }
        if (!TextUtils.isEmpty(R) && (f16 = ChnToSpell.f(R)) != null) {
            this.Z = f16.b();
            this.f445880a0 = f16.a();
        }
    }

    private String R() {
        if (this.X == null) {
            return "";
        }
        return this.X.role_name.get() + "(" + this.X.qq_nick.get() + ")";
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return "";
        }
        return gameFriendSelectorSvr$Friend.f213219id.get();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return "";
        }
        return gameFriendSelectorSvr$Friend.qq_nick.get();
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return "";
        }
        return gameFriendSelectorSvr$Friend.role_name.get();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.Y = str;
        return SearchUtils.m0(str, R(), this.Z, this.f445880a0, Long.MIN_VALUE);
    }

    public GameFriendSelectorSvr$Friend S() {
        return this.X;
    }

    public int T() {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return -1;
        }
        return gameFriendSelectorSvr$Friend.intimacy_type.get();
    }

    public int U() {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return -1;
        }
        return gameFriendSelectorSvr$Friend.intimacy_value.get();
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return "0";
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return "\u6e38\u620f\u597d\u53cb";
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public Object n(String str) {
        GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend = this.X;
        if (gameFriendSelectorSvr$Friend == null) {
            return new Object();
        }
        return gameFriendSelectorSvr$Friend.avatar.get();
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
    public String getKeywords() {
        return this.Y;
    }
}
