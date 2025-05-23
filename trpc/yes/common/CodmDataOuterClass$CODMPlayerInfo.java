package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes30.dex */
public final class CodmDataOuterClass$CODMPlayerInfo extends MessageMicro<CodmDataOuterClass$CODMPlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 800}, new String[]{"player_id", "gopen_id", "state", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "ladder_score", "ladder_level", "yes_uid"}, new Object[]{"", "", 0, "", 0, 0, 0L}, CodmDataOuterClass$CODMPlayerInfo.class);
    public final PBStringField player_id = PBField.initString("");
    public final PBStringField gopen_id = PBField.initString("");
    public final PBInt32Field state = PBField.initInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBInt32Field ladder_score = PBField.initInt32(0);
    public final PBInt32Field ladder_level = PBField.initInt32(0);
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
