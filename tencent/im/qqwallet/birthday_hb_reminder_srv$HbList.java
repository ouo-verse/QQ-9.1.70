package tencent.im.qqwallet;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$HbList extends MessageMicro<birthday_hb_reminder_srv$HbList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 74}, new String[]{"listid", "state", "amount", "uin", "name", "birthdate", "arrival_time", AlbumCacheData.CREATE_TIME, "modify_time"}, new Object[]{"", 0, 0, "", "", "", "", "", ""}, birthday_hb_reminder_srv$HbList.class);
    public final PBStringField listid = PBField.initString("");
    public final PBEnumField state = PBField.initEnum(0);
    public final PBInt32Field amount = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField birthdate = PBField.initString("");
    public final PBStringField arrival_time = PBField.initString("");
    public final PBStringField create_time = PBField.initString("");
    public final PBStringField modify_time = PBField.initString("");
}
