package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.webview.VasWebConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StShare extends MessageMicro<QZoneBaseMeta$StShare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"qzone", "ark", VasWebConstants.REPORT_ORIGIN, "title", "summary", "share_key"}, new Object[]{null, null, null, "", "", ""}, QZoneBaseMeta$StShare.class);

    /* renamed from: qzone, reason: collision with root package name */
    public QZoneBaseMeta$ShareToQzone f430339qzone = new MessageMicro<QZoneBaseMeta$ShareToQzone>() { // from class: qzone.QZoneBaseMeta$ShareToQzone
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext"}, new Object[]{null}, QZoneBaseMeta$ShareToQzone.class);
        public QZoneBaseCommon$Entry ext = new QZoneBaseCommon$Entry();
    };
    public QZoneBaseMeta$ShareToArk ark = new MessageMicro<QZoneBaseMeta$ShareToArk>() { // from class: qzone.QZoneBaseMeta$ShareToArk
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"json_ark", "ark_id", "view_id"}, new Object[]{"", "", ""}, QZoneBaseMeta$ShareToArk.class);
        public final PBStringField json_ark = PBField.initString("");
        public final PBStringField ark_id = PBField.initString("");
        public final PBStringField view_id = PBField.initString("");
    };
    public QZoneBaseMeta$ShareOutside outside = new MessageMicro<QZoneBaseMeta$ShareOutside>() { // from class: qzone.QZoneBaseMeta$ShareOutside
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"jump_url", "wx_miniapp"}, new Object[]{"", null}, QZoneBaseMeta$ShareOutside.class);
        public final PBStringField jump_url = PBField.initString("");
        public QZoneBaseMeta$ShareWXMiniApp wx_miniapp = new MessageMicro<QZoneBaseMeta$ShareWXMiniApp>() { // from class: qzone.QZoneBaseMeta$ShareWXMiniApp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_name", "path"}, new Object[]{"", ""}, QZoneBaseMeta$ShareWXMiniApp.class);
            public final PBStringField app_name = PBField.initString("");
            public final PBStringField path = PBField.initString("");
        };
    };
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField share_key = PBField.initString("");
}
