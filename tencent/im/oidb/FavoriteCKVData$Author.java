package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavoriteCKVData$Author extends MessageMicro<FavoriteCKVData$Author> {
    public static final int Email = 4;
    public static final int Group = 2;
    public static final int Phone = 5;
    public static final int TempTeam = 3;
    public static final int Uin = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_str_id;
    public final PBUInt64Field uint64_group_id;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_num_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint32_type", "uint64_num_id", "bytes_str_id", "uint64_group_id", "bytes_group_name"}, new Object[]{0, 0L, byteStringMicro, 0L, byteStringMicro}, FavoriteCKVData$Author.class);
    }

    public FavoriteCKVData$Author() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_str_id = PBField.initBytes(byteStringMicro);
        this.uint64_group_id = PBField.initUInt64(0L);
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
    }
}
