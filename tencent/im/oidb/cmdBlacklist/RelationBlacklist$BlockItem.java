package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$BlockItem extends MessageMicro<RelationBlacklist$BlockItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"account", "nickname", "avatar"}, new Object[]{null, "", ""}, RelationBlacklist$BlockItem.class);
    public RelationBlacklist$Account account = new RelationBlacklist$Account();
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
}
