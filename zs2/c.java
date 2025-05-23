package zs2;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profile.ProfileCardShareHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.membersetting.handler.MemberSettingHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.state.data.SquareJSConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import ys2.MemberSettingUIModel;
import zs2.a;
import zs2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\tH\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\tR\u001a\u0010\"\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lzs2/c;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lzs2/a;", "Lzs2/b;", "", "troopUin", "memberUin", "", "type", "", "T1", "", "isChecked", "normalMemberDel", "R1", "", "cmd", "U1", "Lcom/tencent/common/app/AppInterface;", "O1", "Landroid/os/Bundle;", "bundle", "init", "onCreate", "onResume", "userIntent", "S1", "Lys2/a;", "Q1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Lzs2/b;", "P1", "()Lzs2/b;", "mNoneValueIntent", "D", "Lys2/a;", "uiModel", "Lcom/tencent/mobileqq/troop/api/observer/e;", "E", "Lcom/tencent/mobileqq/troop/api/observer/e;", "mTroopObserver", "Lcom/tencent/mobileqq/businessCard/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/businessCard/a;", "mBusinessCardObserver", "Lws2/b;", "G", "Lws2/b;", "mMemberSettingObserver", "<init>", "()V", "H", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends BaseViewModel<a, zs2.b> {

    /* renamed from: D, reason: from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: C, reason: from kotlin metadata */
    private final zs2.b mNoneValueIntent = b.C11713b.f453140a;

    /* renamed from: E, reason: from kotlin metadata */
    private final e mTroopObserver = new d();

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.mobileqq.businessCard.a mBusinessCardObserver = new b();

    /* renamed from: G, reason: from kotlin metadata */
    private final ws2.b mMemberSettingObserver = new C11714c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"zs2/c$b", "Lcom/tencent/mobileqq/businessCard/a;", "", "isSuccess", "", "cardId", "", "queryType", "", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends com.tencent.mobileqq.businessCard.a {
        b() {
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void c(boolean isSuccess, String cardId, int queryType) {
            Intrinsics.checkNotNullParameter(cardId, "cardId");
            super.c(isSuccess, cardId, queryType);
            if (isSuccess) {
                AppInterface O1 = c.this.O1();
                MemberSettingUIModel memberSettingUIModel = null;
                Manager manager = O1 != null ? O1.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER) : null;
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.businessCard.BusinessCardManager");
                BusinessCard card = ((BusinessCardManager) manager).i(cardId);
                QLog.i("BusinessCard_observer", 2, "onGetCardInfo success : cardId = " + cardId);
                MutableLiveData<a> obtainUiState = c.this.obtainUiState();
                Intrinsics.checkNotNullExpressionValue(card, "card");
                obtainUiState.setValue(new a.FriendRemarkNameUpdate(card));
                MemberSettingUIModel memberSettingUIModel2 = c.this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel = memberSettingUIModel2;
                }
                memberSettingUIModel.L(card);
                return;
            }
            QLog.e("BusinessCard_observer", 1, "onGetCardInfo failed : cardId = " + cardId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\f"}, d2 = {"zs2/c$d", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "onSetTroopAdminSuccess", "", "errorCode", "onSetTroopAdminFail", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d extends e {
        d() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminFail(int errorCode) {
            if (QLog.isColorLevel()) {
                QLog.e("MemberSettingViewModel", 1, "onSetTroopAdminFail: errorCode=" + errorCode);
            }
            c.this.obtainUiState().setValue(new a.TroopAdminUpdateFail(errorCode));
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminSuccess(String troopCode, String memberUin, byte operation) {
            if (QLog.isColorLevel()) {
                QLog.e("MemberSettingViewModel", 2, "onSetTroopAdminSuccess: troopCode=" + troopCode + ", memberUin=" + memberUin);
            }
            MemberSettingUIModel memberSettingUIModel = c.this.uiModel;
            MemberSettingUIModel memberSettingUIModel2 = null;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            if (Intrinsics.areEqual(memberSettingUIModel.getTroopUin(), troopCode)) {
                MemberSettingUIModel memberSettingUIModel3 = c.this.uiModel;
                if (memberSettingUIModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel3 = null;
                }
                if (Intrinsics.areEqual(memberSettingUIModel3.getMemberUin(), memberUin)) {
                    Byte b16 = vs2.a.f443295b;
                    boolean z16 = false;
                    if (b16 != null && operation == b16.byteValue()) {
                        MemberSettingUIModel memberSettingUIModel4 = c.this.uiModel;
                        if (memberSettingUIModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                            memberSettingUIModel4 = null;
                        }
                        TroopMemberCard troopMemberCard = memberSettingUIModel4.getTroopMemberCard();
                        if (troopMemberCard != null) {
                            troopMemberCard.memberRole = 1;
                        }
                    } else {
                        Byte b17 = vs2.a.f443294a;
                        if (b17 != null && operation == b17.byteValue()) {
                            z16 = true;
                        }
                        if (z16) {
                            MemberSettingUIModel memberSettingUIModel5 = c.this.uiModel;
                            if (memberSettingUIModel5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                                memberSettingUIModel5 = null;
                            }
                            TroopMemberCard troopMemberCard2 = memberSettingUIModel5.getTroopMemberCard();
                            if (troopMemberCard2 != null) {
                                troopMemberCard2.memberRole = 2;
                            }
                        }
                    }
                }
            }
            c.this.obtainUiState().setValue(new a.TroopAdminUpdateSuccess(operation));
            MemberSettingUIModel memberSettingUIModel6 = c.this.uiModel;
            if (memberSettingUIModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel6;
            }
            memberSettingUIModel2.getResultIntent().putExtra("extra_is_admin_modify", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInterface O1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void R1(boolean isChecked, boolean normalMemberDel) {
        AppInterface O1 = O1();
        MemberSettingUIModel memberSettingUIModel = null;
        MemberSettingHandler memberSettingHandler = O1 != null ? new MemberSettingHandler(O1) : null;
        ArrayList arrayList = new ArrayList();
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        String memberUin = memberSettingUIModel2.getMemberUin();
        if (memberUin != null) {
            arrayList.add(Long.valueOf(Long.parseLong(memberUin)));
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel = memberSettingUIModel3;
        }
        String troopUin = memberSettingUIModel.getTroopUin();
        if (troopUin == null || memberSettingHandler == null) {
            return;
        }
        memberSettingHandler.E2(Long.parseLong(troopUin), arrayList, isChecked, normalMemberDel);
    }

    private final void T1(long troopUin, long memberUin, int type) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsOrgMgr()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1316016, 1).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MemberSettingViewModel", 2, "setMsgTip:" + troopUin + ", " + memberUin + ", " + type);
        }
        AppInterface O1 = O1();
        MemberSettingHandler memberSettingHandler = O1 != null ? new MemberSettingHandler(O1) : null;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(memberUin));
        if (memberSettingHandler != null) {
            memberSettingHandler.M2(type, troopUin, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(String cmd) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        memberSettingUIModel.getResultIntent().putExtra("extra_is_msg_tip_modify", true);
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel3;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel2.getTroopMemberCard();
        if (troopMemberCard != null) {
            troopMemberCard.mIsShield = false;
            troopMemberCard.isConcerned = false;
            if (Intrinsics.areEqual("OidbSvc.0x8bb_2", cmd)) {
                troopMemberCard.isConcerned = true;
            } else if (Intrinsics.areEqual("OidbSvc.0x8bb_7", cmd)) {
                troopMemberCard.mIsShield = true;
            }
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: P1, reason: from getter */
    public zs2.b getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    public final MemberSettingUIModel Q1() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel != null) {
            return memberSettingUIModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        return null;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(zs2.b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.UpdateMemberCard) {
            obtainUiState().setValue(new a.TroopMemberNameUpdate(((b.UpdateMemberCard) userIntent).getColorCard()));
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.i9j, 0).show();
            return;
        }
        if (userIntent instanceof b.UpdateGroup) {
            MemberSettingUIModel memberSettingUIModel = this.uiModel;
            MemberSettingUIModel memberSettingUIModel2 = null;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            b.UpdateGroup updateGroup = (b.UpdateGroup) userIntent;
            memberSettingUIModel.r0(updateGroup.getGroupName());
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            memberSettingUIModel3.Z(updateGroup.getGroupId());
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            String strGroup = memberSettingUIModel4.getStrGroup();
            if (strGroup != null) {
                MutableLiveData<a> obtainUiState = obtainUiState();
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel2 = memberSettingUIModel5;
                }
                obtainUiState.setValue(new a.FriendGroupUpdate(strGroup, memberSettingUIModel2.getGroupId()));
                return;
            }
            return;
        }
        if (userIntent instanceof b.UpdateMsgTip) {
            b.UpdateMsgTip updateMsgTip = (b.UpdateMsgTip) userIntent;
            T1(updateMsgTip.getTroopUin(), updateMsgTip.getMemberUin(), updateMsgTip.getType());
            return;
        }
        if (userIntent instanceof b.SetGagTroopMember) {
            AppInterface O1 = O1();
            if (O1 != null) {
                b.SetGagTroopMember setGagTroopMember = (b.SetGagTroopMember) userIntent;
                new MemberSettingHandler(O1).G2(setGagTroopMember.getSUin(), setGagTroopMember.getSMemberUin(), setGagTroopMember.getLSecond());
                return;
            }
            return;
        }
        if (userIntent instanceof b.DeleteTroopInfo) {
            b.DeleteTroopInfo deleteTroopInfo = (b.DeleteTroopInfo) userIntent;
            R1(deleteTroopInfo.getIsChecked(), deleteTroopInfo.getNormalMemberDel());
        } else if (userIntent instanceof b.UpdateDoNotDisturb) {
            obtainUiState().setValue(new a.DoNotDisturbUpdate(((b.UpdateDoNotDisturb) userIntent).getKeySwitch()));
        } else if (userIntent instanceof b.UpdateFriendRemarkByRemark) {
            obtainUiState().setValue(new a.FriendRemarkNameByRemarkUpdate(((b.UpdateFriendRemarkByRemark) userIntent).getRemark()));
        }
    }

    public final void init(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.uiModel = MemberSettingUIModel.INSTANCE.a(bundle);
    }

    public final void onCreate() {
        AppInterface O1 = O1();
        if (O1 != null) {
            O1.addObserver(this.mMemberSettingObserver);
        }
        MobileQQ.sMobileQQ.peekAppRuntime().registObserver(this.mTroopObserver);
        MobileQQ.sMobileQQ.peekAppRuntime().registObserver(this.mBusinessCardObserver);
    }

    public final void onDestroy() {
        AppInterface O1 = O1();
        if (O1 != null) {
            O1.removeObserver(this.mMemberSettingObserver);
        }
        MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.mTroopObserver);
        MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.mBusinessCardObserver);
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        ProfileCardShareHelper shareHelper = memberSettingUIModel.getShareHelper();
        if (shareHelper != null) {
            shareHelper.s();
        }
    }

    public final void onResume() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFirstEnter()) {
            return;
        }
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        if (memberSettingUIModel2.getIsFriend()) {
            MutableLiveData<a> obtainUiState = obtainUiState();
            xs2.c cVar = xs2.c.f448459a;
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            AllInOne allInOne = memberSettingUIModel3.getAllInOne();
            obtainUiState.setValue(new a.SpecialCareUpdate(cVar.g(allInOne != null ? allInOne.uin : null)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u0010H\u0014\u00a8\u0006\u0012"}, d2 = {"zs2/c$c", "Lws2/b;", "", "isSuccess", "", "cmd", "", "errorCode", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "b", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", "gagStatusInfo", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11714c extends ws2.b {
        C11714c() {
        }

        @Override // ws2.b
        protected void a(boolean isSuccess, int errorCode, ArrayList<String> uinList) {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            if (QLog.isColorLevel()) {
                QLog.d("MemberSettingViewModel", 1, "onDeleteTroopMember, isSuccess:" + isSuccess + " errorCode:" + errorCode);
            }
            if (isSuccess) {
                MemberSettingUIModel memberSettingUIModel = c.this.uiModel;
                if (memberSettingUIModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel = null;
                }
                memberSettingUIModel.getResultIntent().putExtra("extra_is_deleted", true);
            }
            c.this.obtainUiState().setValue(new a.DeleteTroopMemberUpdate(isSuccess, errorCode, uinList));
        }

        @Override // ws2.b
        protected void c(com.tencent.mobileqq.troop.troopgag.data.a gagStatusInfo) {
            MemberSettingUIModel memberSettingUIModel = null;
            if ((gagStatusInfo != null ? gagStatusInfo.f300221a : null) != null) {
                String str = gagStatusInfo.f300221a;
                MemberSettingUIModel memberSettingUIModel2 = c.this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel = memberSettingUIModel2;
                }
                if (Intrinsics.areEqual(str, memberSettingUIModel.getTroopUin()) && gagStatusInfo.f300229i == 3) {
                    com.tencent.mobileqq.troop.troopgag.data.b bVar = gagStatusInfo.f300228h;
                    c.this.obtainUiState().setValue(new a.GagMsgSettingUpdate(bVar.f300231b != 0 && bVar.f300230a));
                }
            }
        }

        @Override // ws2.b
        protected void b(boolean isSuccess, String cmd, int errorCode, long[] uinList) {
            if (isSuccess && cmd != null) {
                c.this.U1(cmd);
            }
            c.this.obtainUiState().setValue(new a.MsgTipUpdate(isSuccess, errorCode));
        }
    }
}
