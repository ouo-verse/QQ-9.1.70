package tencent.im.oidb.cmd0x43c;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$MobileInfo extends MessageMicro<Oidb_0x43c$MobileInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{DeviceType.DeviceCategory.MOBILE, IProfileProtocolConst.PARAM_IS_FRIEND, "bind_uin", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "format_mobile"}, new Object[]{"", Boolean.FALSE, 0L, "", ""}, Oidb_0x43c$MobileInfo.class);
    public final PBStringField mobile = PBField.initString("");
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField format_mobile = PBField.initString("");
}
