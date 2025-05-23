package xb0;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.utils.QCircleCommonUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ag extends QCircleBaseShareOperation {
    public ag(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            Intent intent = new Intent(f(), (Class<?>) QCircleHostClassHelper.getChatActivityClass());
            String str = t().feed.poster.f398463id.get();
            intent.putExtra(QCircleHostConstants.AppConstants.Key.UIN(), str);
            intent.putExtra(QCircleHostConstants._ChatActivityConstants.OPEN_CHAT_FRAGMENT(), true);
            if (QCircleCommonUtil.isFriend(str)) {
                intent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
            } else {
                intent.putExtra(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
                intent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
            }
            intent.putExtra(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
            String buddyName = HostDataTransUtils.getBuddyName(str, true);
            if (TextUtils.isEmpty(buddyName) || str.equals(buddyName)) {
                buddyName = t().feed.poster.nick.get();
            }
            String UIN_NAME = QCircleHostConstants.AppConstants.Key.UIN_NAME();
            if (buddyName == null) {
                buddyName = "";
            }
            intent.putExtra(UIN_NAME, buddyName);
            f().startActivity(intent);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
