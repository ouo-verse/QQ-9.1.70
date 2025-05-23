package tencent.im.oidb.cmd0xa2a;

import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$UserInfo extends MessageMicro<oidb_0xa2a$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 58}, new String[]{"uin", "nick", "tag", "tag_color", Element.ELEMENT_NAME_DISTANCE, LocalPhotoFaceInfo.SCORE, "uid"}, new Object[]{0L, "", "", 0, "", 0, ""}, oidb_0xa2a$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
    public final PBUInt32Field tag_color = PBField.initUInt32(0);
    public final PBStringField distance = PBField.initString("");
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBStringField uid = PBField.initString("");
}
