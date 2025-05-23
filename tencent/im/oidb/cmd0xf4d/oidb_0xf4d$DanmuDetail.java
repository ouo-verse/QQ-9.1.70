package tencent.im.oidb.cmd0xf4d;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf4d$DanmuDetail extends MessageMicro<oidb_0xf4d$DanmuDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"danmu_base_info", "post_account_info", "danmu_like_info", "danmu_style_info"}, new Object[]{null, null, null, null}, oidb_0xf4d$DanmuDetail.class);
    public oidb_0xf4d$DanmuBaseInfo danmu_base_info = new MessageMicro<oidb_0xf4d$DanmuBaseInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$DanmuBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50}, new String[]{"danmu_id", "danmu_type", "danmu_source", "danmu_content", "post_delta_time", "rowkey"}, new Object[]{"", 0, 0, "", 0L, ""}, oidb_0xf4d$DanmuBaseInfo.class);
        public final PBStringField danmu_id = PBField.initString("");
        public final PBUInt32Field danmu_type = PBField.initUInt32(0);
        public final PBUInt32Field danmu_source = PBField.initUInt32(0);
        public final PBStringField danmu_content = PBField.initString("");
        public final PBInt64Field post_delta_time = PBField.initInt64(0);
        public final PBStringField rowkey = PBField.initString("");
    };
    public oidb_0xf4d$PostAccountInfo post_account_info = new MessageMicro<oidb_0xf4d$PostAccountInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$PostAccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40}, new String[]{"uin", "uin_source", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, QCircleSchemeAttr.Detail.AVATAR_URL, "identity_status"}, new Object[]{"", 0, "", "", 0}, oidb_0xf4d$PostAccountInfo.class);
        public final PBStringField uin = PBField.initString("");
        public final PBUInt32Field uin_source = PBField.initUInt32(0);
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField avatar_url = PBField.initString("");
        public final PBUInt32Field identity_status = PBField.initUInt32(0);
    };
    public oidb_0xf4d$DanmuLikeInfo danmu_like_info = new MessageMicro<oidb_0xf4d$DanmuLikeInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$DanmuLikeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"like_total_nums", "is_like"}, new Object[]{0L, 0}, oidb_0xf4d$DanmuLikeInfo.class);
        public final PBUInt64Field like_total_nums = PBField.initUInt64(0);
        public final PBUInt32Field is_like = PBField.initUInt32(0);
    };
    public oidb_0xf4d$DanmuStyleInfo danmu_style_info = new MessageMicro<oidb_0xf4d$DanmuStyleInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$DanmuStyleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"location_type", "color_type"}, new Object[]{0, ""}, oidb_0xf4d$DanmuStyleInfo.class);
        public final PBUInt32Field location_type = PBField.initUInt32(0);
        public final PBStringField color_type = PBField.initString("");
    };
}
