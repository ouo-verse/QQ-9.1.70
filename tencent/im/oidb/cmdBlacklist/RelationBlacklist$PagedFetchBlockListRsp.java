package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class RelationBlacklist$PagedFetchBlockListRsp extends MessageMicro<RelationBlacklist$PagedFetchBlockListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"code", "msg", "items", "seq", "next_start", "is_over"}, new Object[]{0L, "", null, 0L, 0L, Boolean.FALSE}, RelationBlacklist$PagedFetchBlockListRsp.class);
    public final PBUInt64Field code = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436005msg = PBField.initString("");
    public final PBRepeatMessageField<RelationBlacklist$BlockItem> items = PBField.initRepeatMessage(RelationBlacklist$BlockItem.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field next_start = PBField.initUInt64(0);
    public final PBBoolField is_over = PBField.initBool(false);
}
