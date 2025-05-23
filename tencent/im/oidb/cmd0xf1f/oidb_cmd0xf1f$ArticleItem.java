package tencent.im.oidb.cmd0xf1f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf1f$ArticleItem extends MessageMicro<oidb_cmd0xf1f$ArticleItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"bytes_rowkey", "uint64_feeds_id", "uint32_play_time", "uint32_is_end", "uint32_duration"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0, 0}, oidb_cmd0xf1f$ArticleItem.class);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_play_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
}
