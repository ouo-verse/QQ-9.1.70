package ys2;

import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.guild.report.impl.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.profile.ProfileCardShareHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import cooperation.qzone.util.PerfTracer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00a0\u00012\u00020\u0001:\u0001\tB\u00f5\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u0010:\u001a\u00020\u0004\u0012\b\b\u0002\u0010>\u001a\u00020\u0004\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010I\u001a\u00020\u0007\u0012\u001c\b\u0002\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010Jj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`K\u0012\b\b\u0002\u0010T\u001a\u00020\u0007\u0012\b\b\u0002\u0010X\u001a\u00020\u0007\u0012\b\b\u0002\u0010\\\u001a\u00020\u0004\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010c\u001a\u00020\u0007\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010n\u001a\u00020\u0007\u0012\b\b\u0002\u0010q\u001a\u00020\u0007\u0012\b\b\u0002\u0010u\u001a\u00020\u0007\u0012\b\b\u0002\u0010w\u001a\u00020\u0007\u0012\b\b\u0002\u0010y\u001a\u00020\u0004\u0012\b\b\u0002\u0010{\u001a\u00020\u0007\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0007\u0012\f\b\u0002\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u0007\u0012\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u009f\u0001\u001a\u00030\u009b\u0001\u0012\t\b\u0002\u0010\u00a1\u0001\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u00a7\u0001\u001a\u00030\u00a2\u0001\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b#\u0010\fR$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b\u0018\u00104\"\u0004\b9\u00106R\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00102\u001a\u0004\b<\u00104\"\u0004\b=\u00106R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b\t\u0010B\"\u0004\bC\u0010DR\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0019\u001a\u0004\bG\u0010\u001b\"\u0004\bH\u0010\u001dR6\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010Jj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0019\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR\"\u0010X\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0019\u001a\u0004\bV\u0010\u001b\"\u0004\bW\u0010\u001dR\"\u0010\\\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u00102\u001a\u0004\bZ\u00104\"\u0004\b[\u00106R$\u0010_\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\n\u001a\u0004\b]\u0010\f\"\u0004\b^\u0010\u000eR\"\u0010c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u0019\u001a\u0004\ba\u0010\u001b\"\u0004\bb\u0010\u001dR$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010\u0019\u001a\u0004\bl\u0010\u001b\"\u0004\bm\u0010\u001dR\"\u0010q\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0019\u001a\u0004\bo\u0010\u001b\"\u0004\bp\u0010\u001dR\"\u0010u\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010\u0019\u001a\u0004\bs\u0010\u001b\"\u0004\bt\u0010\u001dR\"\u0010w\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b2\u0010\u001b\"\u0004\bv\u0010\u001dR\"\u0010y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u00102\u001a\u0004\bY\u00104\"\u0004\bx\u00106R\"\u0010{\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010\u0019\u001a\u0004\b8\u0010\u001b\"\u0004\bz\u0010\u001dR$\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010\n\u001a\u0004\b-\u0010\f\"\u0004\b}\u0010\u000eR#\u0010\u0080\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u00102\u001a\u0004\b;\u00104\"\u0004\b\u007f\u00106R&\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bG\u0010\n\u001a\u0004\b&\u0010\f\"\u0005\b\u0081\u0001\u0010\u000eR$\u0010\u0084\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b1\u0010\u001b\"\u0005\b\u0083\u0001\u0010\u001dR*\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bV\u0010\u0086\u0001\u001a\u0005\b\u0010\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R&\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\ba\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0005\b\u008b\u0001\u0010\u000eR#\u0010\u008d\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u00102\u001a\u0004\b@\u00104\"\u0004\b\u0019\u00106R'\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u008e\u0001\u0010\n\u001a\u0004\br\u0010\f\"\u0005\b\u008f\u0001\u0010\u000eR&\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b2\u0010\n\u001a\u0004\b`\u0010\f\"\u0005\b\u0091\u0001\u0010\u000eR&\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bC\u0010\n\u001a\u0004\bU\u0010\f\"\u0005\b\u0093\u0001\u0010\u000eR&\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bt\u0010\n\u001a\u0004\b\"\u0010\f\"\u0005\b\u0095\u0001\u0010\u000eR&\u0010\u0098\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0019\u001a\u0005\b\u008e\u0001\u0010\u001b\"\u0005\b\u0097\u0001\u0010\u001dR%\u0010\u009a\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u008b\u0001\u0010\u0019\u001a\u0004\bF\u0010\u001b\"\u0005\b\u0099\u0001\u0010\u001dR'\u0010\u009f\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b9\u0010C\u001a\u0005\b\u001e\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R%\u0010\u00a1\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u009d\u0001\u0010\u0019\u001a\u0004\b|\u0010\u001b\"\u0005\b\u00a0\u0001\u0010\u001dR)\u0010\u00a7\u0001\u001a\u00030\u00a2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0095\u0001\u0010\u00a3\u0001\u001a\u0005\be\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u00a8\u0006\u00aa\u0001"}, d2 = {"Lys2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "y", "()Ljava/lang/String;", "w0", "(Ljava/lang/String;)V", "troopUin", "b", "getTroopCode", "t0", IProfileProtocolConst.PARAM_TROOP_CODE, "c", "getTroopName", "v0", "troopName", "d", "Z", "isQidianPrivateTroop", "()Z", "k0", "(Z)V", "e", "D", "a0", "isHasInteraction", "f", "getLevelMaps", "levelMaps", "Lcom/tencent/mobileqq/data/troop/TroopMemberCard;", "g", "Lcom/tencent/mobileqq/data/troop/TroopMemberCard;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/data/troop/TroopMemberCard;", "u0", "(Lcom/tencent/mobileqq/data/troop/TroopMemberCard;)V", "troopMemberCard", h.F, DomainData.DOMAIN_NAME, "d0", "memberUin", "i", "I", "o", "()I", "e0", "(I)V", "myRole", "j", "N", "cardType", "k", "getFromFlag", "Y", "fromFlag", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "l", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "()Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "J", "(Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V", "allInOne", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, ExifInterface.LATITUDE_SOUTH, IProfileProtocolConst.PARAM_IS_FRIEND, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getOrgIds", "()Ljava/util/ArrayList;", "h0", "(Ljava/util/ArrayList;)V", "orgIds", "getHasOrgs", "b0", "hasOrgs", "p", "E", "i0", "isOrgMgr", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "q0", "specialFlag", "r", "l0", "qidianShowUin", ReportConstant.COSTREPORT_PREFIX, UserInfo.SEX_FEMALE, "j0", "isQidianMaster", "Lcom/tencent/mobileqq/profile/ProfileCardShareHelper;", "t", "Lcom/tencent/mobileqq/profile/ProfileCardShareHelper;", "u", "()Lcom/tencent/mobileqq/profile/ProfileCardShareHelper;", "n0", "(Lcom/tencent/mobileqq/profile/ProfileCardShareHelper;)V", "shareHelper", "B", BdhLogUtil.LogTag.Tag_Req, "isForbidAccount", "G", "o0", "isShield", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "K", "isBlacklist", "s0", "isTransferShield", "g0", "opsFlags", "W", "friendIntimateOpen", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "U", "friendIntimateBindUrl", "X", "friendIntimateResIcon", "T", "friendIntimateBindName", "V", "friendIntimateIsExtinguish", "Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", "Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", "()Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", "L", "(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;)V", "businessCard", "M", "businessCardMessage", "groupId", "H", "r0", "strGroup", "m0", "remark", "f0", "nickname", "P", "currentNick", "p0", "isSpecialCare", "c0", "keyNotDisturb", "", "()J", "O", "(J)V", "clickTime", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isFirstEnter", "Landroid/content/Intent;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "setResultIntent", "(Landroid/content/Intent;)V", "resultIntent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/tencent/mobileqq/data/troop/TroopMemberCard;Ljava/lang/String;IIILcom/tencent/mobileqq/profilecard/data/AllInOne;ZLjava/util/ArrayList;ZZILjava/lang/String;ZLcom/tencent/mobileqq/profile/ProfileCardShareHelper;ZZZZIZLjava/lang/String;ILjava/lang/String;ZLcom/tencent/mobileqq/businessCard/data/BusinessCard;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJZLandroid/content/Intent;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ys2.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class MemberSettingUIModel {

    /* renamed from: Q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private String friendIntimateBindUrl;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private int friendIntimateResIcon;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private String friendIntimateBindName;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private boolean friendIntimateIsExtinguish;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private BusinessCard businessCard;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private String businessCardMessage;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private int groupId;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private String strGroup;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private String remark;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private String nickname;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private String currentNick;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private boolean isSpecialCare;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private boolean keyNotDisturb;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    private long clickTime;

    /* renamed from: O, reason: from kotlin metadata and from toString */
    private boolean isFirstEnter;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    private Intent resultIntent;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String troopCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String troopName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isQidianPrivateTroop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isHasInteraction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String levelMaps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private TroopMemberCard troopMemberCard;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String memberUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int myRole;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int cardType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int fromFlag;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private AllInOne allInOne;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFriend;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<String> orgIds;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasOrgs;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isOrgMgr;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int specialFlag;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private String qidianShowUin;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isQidianMaster;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private ProfileCardShareHelper shareHelper;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isForbidAccount;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShield;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isBlacklist;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isTransferShield;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private int opsFlags;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean friendIntimateOpen;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lys2/a$a;", "", "Landroid/os/Bundle;", "extra", "Lys2/a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ys2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final MemberSettingUIModel a(Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            MemberSettingUIModel memberSettingUIModel = new MemberSettingUIModel(null, null, null, false, false, null, null, null, 0, 0, 0, null, false, null, false, false, 0, null, false, null, false, false, false, false, 0, false, null, 0, null, false, null, null, 0, null, null, null, null, false, false, 0L, false, null, -1, 1023, null);
            memberSettingUIModel.u0((TroopMemberCard) extra.getSerializable("troopMemberCard"));
            memberSettingUIModel.w0(extra.getString("troopUin"));
            int i3 = 0;
            memberSettingUIModel.k0(extra.getBoolean("qidian_private_troop", false));
            memberSettingUIModel.t0(extra.getString(IProfileProtocolConst.PARAM_TROOP_CODE));
            memberSettingUIModel.v0(extra.getString("troopName"));
            memberSettingUIModel.Y(extra.getInt("fromFlag", 0));
            memberSettingUIModel.i0(extra.getBoolean("isOrgMgr", false));
            memberSettingUIModel.b0(extra.getBoolean("hasOrgs", false));
            memberSettingUIModel.h0(extra.getStringArrayList("orgIds"));
            memberSettingUIModel.S(extra.getBoolean(IProfileProtocolConst.PARAM_IS_FRIEND, false));
            memberSettingUIModel.J((AllInOne) extra.getParcelable(IProfileCardConst.KEY_ALL_IN_ONE));
            try {
                memberSettingUIModel.q0(extra.getInt("specialFlag", 17));
            } catch (ClassCastException unused) {
                memberSettingUIModel.q0(17);
                QLog.e("MemberSettingUIModel", 1, "specialFlag ClassCastException");
            }
            memberSettingUIModel.l0(extra.getString("qidianshowUin"));
            memberSettingUIModel.j0(extra.getBoolean("isQidianMaster", false));
            memberSettingUIModel.f0(extra.getString("key_nick_name"));
            memberSettingUIModel.L((BusinessCard) extra.getParcelable("businessCard"));
            memberSettingUIModel.o0(extra.getBoolean("isMsgShielded", false));
            memberSettingUIModel.W(extra.getBoolean("friend_intimate_open", memberSettingUIModel.getFriendIntimateOpen()));
            memberSettingUIModel.U(extra.getString("friend_intimate_bind_url"));
            memberSettingUIModel.T(extra.getString("friend_intimate_bind_name"));
            memberSettingUIModel.X(extra.getInt("friend_intimate_bind_res_icon", 0));
            memberSettingUIModel.V(extra.getBoolean("friend_intimate_isExtinguish", false));
            memberSettingUIModel.R(extra.getBoolean("isForbidAccount", false));
            memberSettingUIModel.m0(extra.getString("key_remark"));
            memberSettingUIModel.Z(extra.getInt(MiniAppTranRoomIdServlet.KEY_GROUP_ID, 0));
            memberSettingUIModel.r0(extra.getString("key_group_name"));
            memberSettingUIModel.P(extra.getString("key_current_nick"));
            memberSettingUIModel.p0(extra.getBoolean("key_is_specialcare", false));
            memberSettingUIModel.c0(extra.getBoolean("key_not_disturb", false));
            memberSettingUIModel.a0(extra.getBoolean("key_is_has_interaction", false));
            memberSettingUIModel.O(extra.getLong(PerfTracer.PARAM_CLICK_TIME, 0L));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            try {
                TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(memberSettingUIModel.getTroopUin());
                TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
                if (troopMemberCard != null) {
                    long j3 = troopMemberCard.memberUin;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(j3);
                    memberSettingUIModel.d0(sb5.toString());
                }
                String currentAccountUin = appInterface != null ? appInterface.getCurrentAccountUin() : null;
                if (currentAccountUin == null) {
                    currentAccountUin = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app?.currentAccountUin ?: \"\"");
                }
                boolean areEqual = Intrinsics.areEqual(memberSettingUIModel.getMemberUin(), currentAccountUin);
                int i16 = 2;
                if (!areEqual) {
                    i3 = memberSettingUIModel.getIsFriend() ? 1 : 2;
                }
                memberSettingUIModel.N(i3);
                memberSettingUIModel.e0(1);
                if (troopInfoFromCache != null) {
                    if (troopInfoFromCache.isOwner()) {
                        i16 = 3;
                    } else if (!troopInfoFromCache.isAdmin()) {
                        i16 = 1;
                    }
                    memberSettingUIModel.e0(i16);
                }
            } catch (Exception e16) {
                QLog.e("MemberSettingUIModel", 1, "checkIntentParams:" + e16);
            }
            return memberSettingUIModel;
        }
    }

    public MemberSettingUIModel() {
        this(null, null, null, false, false, null, null, null, 0, 0, 0, null, false, null, false, false, 0, null, false, null, false, false, false, false, 0, false, null, 0, null, false, null, null, 0, null, null, null, null, false, false, 0L, false, null, -1, 1023, null);
    }

    /* renamed from: A, reason: from getter */
    public final boolean getIsFirstEnter() {
        return this.isFirstEnter;
    }

    /* renamed from: B, reason: from getter */
    public final boolean getIsForbidAccount() {
        return this.isForbidAccount;
    }

    /* renamed from: C, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* renamed from: D, reason: from getter */
    public final boolean getIsHasInteraction() {
        return this.isHasInteraction;
    }

    /* renamed from: E, reason: from getter */
    public final boolean getIsOrgMgr() {
        return this.isOrgMgr;
    }

    /* renamed from: F, reason: from getter */
    public final boolean getIsQidianMaster() {
        return this.isQidianMaster;
    }

    /* renamed from: G, reason: from getter */
    public final boolean getIsShield() {
        return this.isShield;
    }

    /* renamed from: H, reason: from getter */
    public final boolean getIsSpecialCare() {
        return this.isSpecialCare;
    }

    /* renamed from: I, reason: from getter */
    public final boolean getIsTransferShield() {
        return this.isTransferShield;
    }

    public final void J(AllInOne allInOne) {
        this.allInOne = allInOne;
    }

    public final void K(boolean z16) {
        this.isBlacklist = z16;
    }

    public final void L(BusinessCard businessCard) {
        this.businessCard = businessCard;
    }

    public final void M(String str) {
        this.businessCardMessage = str;
    }

    public final void N(int i3) {
        this.cardType = i3;
    }

    public final void O(long j3) {
        this.clickTime = j3;
    }

    public final void P(String str) {
        this.currentNick = str;
    }

    public final void Q(boolean z16) {
        this.isFirstEnter = z16;
    }

    public final void R(boolean z16) {
        this.isForbidAccount = z16;
    }

    public final void S(boolean z16) {
        this.isFriend = z16;
    }

    public final void T(String str) {
        this.friendIntimateBindName = str;
    }

    public final void U(String str) {
        this.friendIntimateBindUrl = str;
    }

    public final void V(boolean z16) {
        this.friendIntimateIsExtinguish = z16;
    }

    public final void W(boolean z16) {
        this.friendIntimateOpen = z16;
    }

    public final void X(int i3) {
        this.friendIntimateResIcon = i3;
    }

    public final void Y(int i3) {
        this.fromFlag = i3;
    }

    public final void Z(int i3) {
        this.groupId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final AllInOne getAllInOne() {
        return this.allInOne;
    }

    public final void a0(boolean z16) {
        this.isHasInteraction = z16;
    }

    /* renamed from: b, reason: from getter */
    public final BusinessCard getBusinessCard() {
        return this.businessCard;
    }

    public final void b0(boolean z16) {
        this.hasOrgs = z16;
    }

    /* renamed from: c, reason: from getter */
    public final String getBusinessCardMessage() {
        return this.businessCardMessage;
    }

    public final void c0(boolean z16) {
        this.keyNotDisturb = z16;
    }

    /* renamed from: d, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    public final void d0(String str) {
        this.memberUin = str;
    }

    /* renamed from: e, reason: from getter */
    public final long getClickTime() {
        return this.clickTime;
    }

    public final void e0(int i3) {
        this.myRole = i3;
    }

    /* renamed from: f, reason: from getter */
    public final String getCurrentNick() {
        return this.currentNick;
    }

    public final void f0(String str) {
        this.nickname = str;
    }

    /* renamed from: g, reason: from getter */
    public final String getFriendIntimateBindName() {
        return this.friendIntimateBindName;
    }

    public final void g0(int i3) {
        this.opsFlags = i3;
    }

    /* renamed from: h, reason: from getter */
    public final String getFriendIntimateBindUrl() {
        return this.friendIntimateBindUrl;
    }

    public final void h0(ArrayList<String> arrayList) {
        this.orgIds = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.troopUin;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.troopCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.troopName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z16 = this.isQidianPrivateTroop;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        boolean z17 = this.isHasInteraction;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        String str4 = this.levelMaps;
        int hashCode4 = (i18 + (str4 == null ? 0 : str4.hashCode())) * 31;
        TroopMemberCard troopMemberCard = this.troopMemberCard;
        int hashCode5 = (hashCode4 + (troopMemberCard == null ? 0 : troopMemberCard.hashCode())) * 31;
        String str5 = this.memberUin;
        int hashCode6 = (((((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.myRole) * 31) + this.cardType) * 31) + this.fromFlag) * 31;
        AllInOne allInOne = this.allInOne;
        int hashCode7 = (hashCode6 + (allInOne == null ? 0 : allInOne.hashCode())) * 31;
        boolean z18 = this.isFriend;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (hashCode7 + i19) * 31;
        ArrayList<String> arrayList = this.orgIds;
        int hashCode8 = (i26 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        boolean z19 = this.hasOrgs;
        int i27 = z19;
        if (z19 != 0) {
            i27 = 1;
        }
        int i28 = (hashCode8 + i27) * 31;
        boolean z26 = this.isOrgMgr;
        int i29 = z26;
        if (z26 != 0) {
            i29 = 1;
        }
        int i36 = (((i28 + i29) * 31) + this.specialFlag) * 31;
        String str6 = this.qidianShowUin;
        int hashCode9 = (i36 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z27 = this.isQidianMaster;
        int i37 = z27;
        if (z27 != 0) {
            i37 = 1;
        }
        int i38 = (hashCode9 + i37) * 31;
        ProfileCardShareHelper profileCardShareHelper = this.shareHelper;
        int hashCode10 = (i38 + (profileCardShareHelper == null ? 0 : profileCardShareHelper.hashCode())) * 31;
        boolean z28 = this.isForbidAccount;
        int i39 = z28;
        if (z28 != 0) {
            i39 = 1;
        }
        int i46 = (hashCode10 + i39) * 31;
        boolean z29 = this.isShield;
        int i47 = z29;
        if (z29 != 0) {
            i47 = 1;
        }
        int i48 = (i46 + i47) * 31;
        boolean z36 = this.isBlacklist;
        int i49 = z36;
        if (z36 != 0) {
            i49 = 1;
        }
        int i56 = (i48 + i49) * 31;
        boolean z37 = this.isTransferShield;
        int i57 = z37;
        if (z37 != 0) {
            i57 = 1;
        }
        int i58 = (((i56 + i57) * 31) + this.opsFlags) * 31;
        boolean z38 = this.friendIntimateOpen;
        int i59 = z38;
        if (z38 != 0) {
            i59 = 1;
        }
        int i65 = (i58 + i59) * 31;
        String str7 = this.friendIntimateBindUrl;
        int hashCode11 = (((i65 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.friendIntimateResIcon) * 31;
        String str8 = this.friendIntimateBindName;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        boolean z39 = this.friendIntimateIsExtinguish;
        int i66 = z39;
        if (z39 != 0) {
            i66 = 1;
        }
        int i67 = (hashCode12 + i66) * 31;
        BusinessCard businessCard = this.businessCard;
        int hashCode13 = (i67 + (businessCard == null ? 0 : businessCard.hashCode())) * 31;
        String str9 = this.businessCardMessage;
        int hashCode14 = (((hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.groupId) * 31;
        String str10 = this.strGroup;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.remark;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.nickname;
        int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currentNick;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        boolean z46 = this.isSpecialCare;
        int i68 = z46;
        if (z46 != 0) {
            i68 = 1;
        }
        int i69 = (hashCode18 + i68) * 31;
        boolean z47 = this.keyNotDisturb;
        int i75 = z47;
        if (z47 != 0) {
            i75 = 1;
        }
        int a16 = (((i69 + i75) * 31) + b.a(this.clickTime)) * 31;
        boolean z48 = this.isFirstEnter;
        return ((a16 + (z48 ? 1 : z48 ? 1 : 0)) * 31) + this.resultIntent.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getFriendIntimateIsExtinguish() {
        return this.friendIntimateIsExtinguish;
    }

    public final void i0(boolean z16) {
        this.isOrgMgr = z16;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getFriendIntimateOpen() {
        return this.friendIntimateOpen;
    }

    public final void j0(boolean z16) {
        this.isQidianMaster = z16;
    }

    /* renamed from: k, reason: from getter */
    public final int getFriendIntimateResIcon() {
        return this.friendIntimateResIcon;
    }

    public final void k0(boolean z16) {
        this.isQidianPrivateTroop = z16;
    }

    /* renamed from: l, reason: from getter */
    public final int getGroupId() {
        return this.groupId;
    }

    public final void l0(String str) {
        this.qidianShowUin = str;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getKeyNotDisturb() {
        return this.keyNotDisturb;
    }

    public final void m0(String str) {
        this.remark = str;
    }

    /* renamed from: n, reason: from getter */
    public final String getMemberUin() {
        return this.memberUin;
    }

    public final void n0(ProfileCardShareHelper profileCardShareHelper) {
        this.shareHelper = profileCardShareHelper;
    }

    /* renamed from: o, reason: from getter */
    public final int getMyRole() {
        return this.myRole;
    }

    public final void o0(boolean z16) {
        this.isShield = z16;
    }

    /* renamed from: p, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    public final void p0(boolean z16) {
        this.isSpecialCare = z16;
    }

    /* renamed from: q, reason: from getter */
    public final int getOpsFlags() {
        return this.opsFlags;
    }

    public final void q0(int i3) {
        this.specialFlag = i3;
    }

    /* renamed from: r, reason: from getter */
    public final String getQidianShowUin() {
        return this.qidianShowUin;
    }

    public final void r0(String str) {
        this.strGroup = str;
    }

    /* renamed from: s, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    public final void s0(boolean z16) {
        this.isTransferShield = z16;
    }

    /* renamed from: t, reason: from getter */
    public final Intent getResultIntent() {
        return this.resultIntent;
    }

    public final void t0(String str) {
        this.troopCode = str;
    }

    /* renamed from: u, reason: from getter */
    public final ProfileCardShareHelper getShareHelper() {
        return this.shareHelper;
    }

    public final void u0(TroopMemberCard troopMemberCard) {
        this.troopMemberCard = troopMemberCard;
    }

    /* renamed from: v, reason: from getter */
    public final int getSpecialFlag() {
        return this.specialFlag;
    }

    public final void v0(String str) {
        this.troopName = str;
    }

    /* renamed from: w, reason: from getter */
    public final String getStrGroup() {
        return this.strGroup;
    }

    public final void w0(String str) {
        this.troopUin = str;
    }

    /* renamed from: x, reason: from getter */
    public final TroopMemberCard getTroopMemberCard() {
        return this.troopMemberCard;
    }

    /* renamed from: y, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: z, reason: from getter */
    public final boolean getIsBlacklist() {
        return this.isBlacklist;
    }

    public MemberSettingUIModel(String str, String str2, String str3, boolean z16, boolean z17, String str4, TroopMemberCard troopMemberCard, String str5, int i3, int i16, int i17, AllInOne allInOne, boolean z18, ArrayList<String> arrayList, boolean z19, boolean z26, int i18, String str6, boolean z27, ProfileCardShareHelper profileCardShareHelper, boolean z28, boolean z29, boolean z36, boolean z37, int i19, boolean z38, String str7, int i26, String str8, boolean z39, BusinessCard businessCard, String str9, int i27, String str10, String str11, String str12, String str13, boolean z46, boolean z47, long j3, boolean z48, Intent resultIntent) {
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        this.troopUin = str;
        this.troopCode = str2;
        this.troopName = str3;
        this.isQidianPrivateTroop = z16;
        this.isHasInteraction = z17;
        this.levelMaps = str4;
        this.troopMemberCard = troopMemberCard;
        this.memberUin = str5;
        this.myRole = i3;
        this.cardType = i16;
        this.fromFlag = i17;
        this.allInOne = allInOne;
        this.isFriend = z18;
        this.orgIds = arrayList;
        this.hasOrgs = z19;
        this.isOrgMgr = z26;
        this.specialFlag = i18;
        this.qidianShowUin = str6;
        this.isQidianMaster = z27;
        this.shareHelper = profileCardShareHelper;
        this.isForbidAccount = z28;
        this.isShield = z29;
        this.isBlacklist = z36;
        this.isTransferShield = z37;
        this.opsFlags = i19;
        this.friendIntimateOpen = z38;
        this.friendIntimateBindUrl = str7;
        this.friendIntimateResIcon = i26;
        this.friendIntimateBindName = str8;
        this.friendIntimateIsExtinguish = z39;
        this.businessCard = businessCard;
        this.businessCardMessage = str9;
        this.groupId = i27;
        this.strGroup = str10;
        this.remark = str11;
        this.nickname = str12;
        this.currentNick = str13;
        this.isSpecialCare = z46;
        this.keyNotDisturb = z47;
        this.clickTime = j3;
        this.isFirstEnter = z48;
        this.resultIntent = resultIntent;
    }

    public String toString() {
        return "MemberSettingUIModel(troopUin=" + this.troopUin + ", troopCode=" + this.troopCode + ", troopName=" + this.troopName + ", isQidianPrivateTroop=" + this.isQidianPrivateTroop + ", isHasInteraction=" + this.isHasInteraction + ", levelMaps=" + this.levelMaps + ", troopMemberCard=" + this.troopMemberCard + ", memberUin=" + this.memberUin + ", myRole=" + this.myRole + ", cardType=" + this.cardType + ", fromFlag=" + this.fromFlag + ", allInOne=" + this.allInOne + ", isFriend=" + this.isFriend + ", orgIds=" + this.orgIds + ", hasOrgs=" + this.hasOrgs + ", isOrgMgr=" + this.isOrgMgr + ", specialFlag=" + this.specialFlag + ", qidianShowUin=" + this.qidianShowUin + ", isQidianMaster=" + this.isQidianMaster + ", shareHelper=" + this.shareHelper + ", isForbidAccount=" + this.isForbidAccount + ", isShield=" + this.isShield + ", isBlacklist=" + this.isBlacklist + ", isTransferShield=" + this.isTransferShield + ", opsFlags=" + this.opsFlags + ", friendIntimateOpen=" + this.friendIntimateOpen + ", friendIntimateBindUrl=" + this.friendIntimateBindUrl + ", friendIntimateResIcon=" + this.friendIntimateResIcon + ", friendIntimateBindName=" + this.friendIntimateBindName + ", friendIntimateIsExtinguish=" + this.friendIntimateIsExtinguish + ", businessCard=" + this.businessCard + ", businessCardMessage=" + this.businessCardMessage + ", groupId=" + this.groupId + ", strGroup=" + this.strGroup + ", remark=" + this.remark + ", nickname=" + this.nickname + ", currentNick=" + this.currentNick + ", isSpecialCare=" + this.isSpecialCare + ", keyNotDisturb=" + this.keyNotDisturb + ", clickTime=" + this.clickTime + ", isFirstEnter=" + this.isFirstEnter + ", resultIntent=" + this.resultIntent + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberSettingUIModel)) {
            return false;
        }
        MemberSettingUIModel memberSettingUIModel = (MemberSettingUIModel) other;
        return Intrinsics.areEqual(this.troopUin, memberSettingUIModel.troopUin) && Intrinsics.areEqual(this.troopCode, memberSettingUIModel.troopCode) && Intrinsics.areEqual(this.troopName, memberSettingUIModel.troopName) && this.isQidianPrivateTroop == memberSettingUIModel.isQidianPrivateTroop && this.isHasInteraction == memberSettingUIModel.isHasInteraction && Intrinsics.areEqual(this.levelMaps, memberSettingUIModel.levelMaps) && Intrinsics.areEqual(this.troopMemberCard, memberSettingUIModel.troopMemberCard) && Intrinsics.areEqual(this.memberUin, memberSettingUIModel.memberUin) && this.myRole == memberSettingUIModel.myRole && this.cardType == memberSettingUIModel.cardType && this.fromFlag == memberSettingUIModel.fromFlag && Intrinsics.areEqual(this.allInOne, memberSettingUIModel.allInOne) && this.isFriend == memberSettingUIModel.isFriend && Intrinsics.areEqual(this.orgIds, memberSettingUIModel.orgIds) && this.hasOrgs == memberSettingUIModel.hasOrgs && this.isOrgMgr == memberSettingUIModel.isOrgMgr && this.specialFlag == memberSettingUIModel.specialFlag && Intrinsics.areEqual(this.qidianShowUin, memberSettingUIModel.qidianShowUin) && this.isQidianMaster == memberSettingUIModel.isQidianMaster && Intrinsics.areEqual(this.shareHelper, memberSettingUIModel.shareHelper) && this.isForbidAccount == memberSettingUIModel.isForbidAccount && this.isShield == memberSettingUIModel.isShield && this.isBlacklist == memberSettingUIModel.isBlacklist && this.isTransferShield == memberSettingUIModel.isTransferShield && this.opsFlags == memberSettingUIModel.opsFlags && this.friendIntimateOpen == memberSettingUIModel.friendIntimateOpen && Intrinsics.areEqual(this.friendIntimateBindUrl, memberSettingUIModel.friendIntimateBindUrl) && this.friendIntimateResIcon == memberSettingUIModel.friendIntimateResIcon && Intrinsics.areEqual(this.friendIntimateBindName, memberSettingUIModel.friendIntimateBindName) && this.friendIntimateIsExtinguish == memberSettingUIModel.friendIntimateIsExtinguish && Intrinsics.areEqual(this.businessCard, memberSettingUIModel.businessCard) && Intrinsics.areEqual(this.businessCardMessage, memberSettingUIModel.businessCardMessage) && this.groupId == memberSettingUIModel.groupId && Intrinsics.areEqual(this.strGroup, memberSettingUIModel.strGroup) && Intrinsics.areEqual(this.remark, memberSettingUIModel.remark) && Intrinsics.areEqual(this.nickname, memberSettingUIModel.nickname) && Intrinsics.areEqual(this.currentNick, memberSettingUIModel.currentNick) && this.isSpecialCare == memberSettingUIModel.isSpecialCare && this.keyNotDisturb == memberSettingUIModel.keyNotDisturb && this.clickTime == memberSettingUIModel.clickTime && this.isFirstEnter == memberSettingUIModel.isFirstEnter && Intrinsics.areEqual(this.resultIntent, memberSettingUIModel.resultIntent);
    }

    public /* synthetic */ MemberSettingUIModel(String str, String str2, String str3, boolean z16, boolean z17, String str4, TroopMemberCard troopMemberCard, String str5, int i3, int i16, int i17, AllInOne allInOne, boolean z18, ArrayList arrayList, boolean z19, boolean z26, int i18, String str6, boolean z27, ProfileCardShareHelper profileCardShareHelper, boolean z28, boolean z29, boolean z36, boolean z37, int i19, boolean z38, String str7, int i26, String str8, boolean z39, BusinessCard businessCard, String str9, int i27, String str10, String str11, String str12, String str13, boolean z46, boolean z47, long j3, boolean z48, Intent intent, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? null : str, (i28 & 2) != 0 ? null : str2, (i28 & 4) != 0 ? null : str3, (i28 & 8) != 0 ? false : z16, (i28 & 16) != 0 ? false : z17, (i28 & 32) != 0 ? null : str4, (i28 & 64) != 0 ? null : troopMemberCard, (i28 & 128) != 0 ? null : str5, (i28 & 256) != 0 ? 0 : i3, (i28 & 512) != 0 ? -1 : i16, (i28 & 1024) == 0 ? i17 : -1, (i28 & 2048) != 0 ? null : allInOne, (i28 & 4096) != 0 ? false : z18, (i28 & 8192) != 0 ? null : arrayList, (i28 & 16384) != 0 ? true : z19, (i28 & 32768) != 0 ? true : z26, (i28 & 65536) != 0 ? 0 : i18, (i28 & 131072) != 0 ? null : str6, (i28 & 262144) != 0 ? false : z27, (i28 & 524288) != 0 ? null : profileCardShareHelper, (i28 & 1048576) != 0 ? false : z28, (i28 & 2097152) != 0 ? false : z29, (i28 & 4194304) != 0 ? false : z36, (i28 & 8388608) != 0 ? false : z37, (i28 & 16777216) != 0 ? 0 : i19, (i28 & 33554432) != 0 ? false : z38, (i28 & 67108864) != 0 ? null : str7, (i28 & 134217728) != 0 ? 0 : i26, (i28 & 268435456) != 0 ? null : str8, (i28 & 536870912) != 0 ? false : z39, (i28 & 1073741824) != 0 ? null : businessCard, (i28 & Integer.MIN_VALUE) != 0 ? null : str9, (i29 & 1) != 0 ? 0 : i27, (i29 & 2) != 0 ? null : str10, (i29 & 4) != 0 ? null : str11, (i29 & 8) != 0 ? null : str12, (i29 & 16) != 0 ? null : str13, (i29 & 32) != 0 ? false : z46, (i29 & 64) != 0 ? false : z47, (i29 & 128) != 0 ? 0L : j3, (i29 & 256) == 0 ? z48 : true, (i29 & 512) != 0 ? new Intent() : intent);
    }
}
