package tencent.im.qqgame;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$CheckURLResponse extends MessageMicro<QQGameCheckDownload$CheckURLResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"ret", "msg", "install_bar_tip", "register_bar_tip", "replacement_url", "quic_url", "remind"}, new Object[]{0, "", null, null, null, null, null}, QQGameCheckDownload$CheckURLResponse.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436032msg = PBField.initString("");
    public QQGameCheckDownload$BarTip install_bar_tip = new MessageMicro<QQGameCheckDownload$BarTip>() { // from class: tencent.im.qqgame.QQGameCheckDownload$BarTip
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"icon", "text", "jump_url", "start_ts", "end_ts", AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT}, new Object[]{"", "", "", 0L, 0L, ""}, QQGameCheckDownload$BarTip.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
        public final PBInt64Field start_ts = PBField.initInt64(0);
        public final PBInt64Field end_ts = PBField.initInt64(0);
        public final PBStringField default_text = PBField.initString("");
    };
    public QQGameCheckDownload$BarTip register_bar_tip = new MessageMicro<QQGameCheckDownload$BarTip>() { // from class: tencent.im.qqgame.QQGameCheckDownload$BarTip
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"icon", "text", "jump_url", "start_ts", "end_ts", AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT}, new Object[]{"", "", "", 0L, 0L, ""}, QQGameCheckDownload$BarTip.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
        public final PBInt64Field start_ts = PBField.initInt64(0);
        public final PBInt64Field end_ts = PBField.initInt64(0);
        public final PBStringField default_text = PBField.initString("");
    };
    public QQGameCheckDownload$ReplacementURL replacement_url = new QQGameCheckDownload$ReplacementURL();
    public QQGameCheckDownload$QuicURL quic_url = new MessageMicro<QQGameCheckDownload$QuicURL>() { // from class: tencent.im.qqgame.QQGameCheckDownload$QuicURL
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"flag", "channel_num"}, new Object[]{Boolean.FALSE, 0}, QQGameCheckDownload$QuicURL.class);
        public final PBBoolField flag = PBField.initBool(false);
        public final PBInt32Field channel_num = PBField.initInt32(0);
    };
    public QQGameCheckDownload$DownloadRemind remind = new QQGameCheckDownload$DownloadRemind();
}
