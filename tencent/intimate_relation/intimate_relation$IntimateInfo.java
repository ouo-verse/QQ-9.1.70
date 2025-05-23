package tencent.intimate_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class intimate_relation$IntimateInfo extends MessageMicro<intimate_relation$IntimateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 74}, new String[]{"lover", "ladybro", "buddy", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "face_url", "is_del", "frd_uin", "modify_time", "bestfriend"}, new Object[]{null, null, null, "", "", Boolean.FALSE, 0L, 0, null}, intimate_relation$IntimateInfo.class);
    public intimate_relation$IntimateLover lover = new intimate_relation$IntimateLover();
    public intimate_relation$IntimateLadybro ladybro = new intimate_relation$IntimateLadybro();
    public intimate_relation$IntimateBuddy buddy = new intimate_relation$IntimateBuddy();
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField face_url = PBField.initString("");
    public final PBBoolField is_del = PBField.initBool(false);
    public final PBUInt64Field frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field modify_time = PBField.initUInt32(0);
    public intimate_relation$IntimateBestFriend bestfriend = new intimate_relation$IntimateBestFriend();
}
