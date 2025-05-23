package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicAssociationWord$AssociationItem extends MessageMicro<DynamicAssociationWord$AssociationItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_mask;
    public final PBBytesField jmp_url;
    public final PBBytesField pic_url;
    public final PBBytesField subWord;
    public final PBUInt32Field type;
    public final PBBytesField word;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"word", "jmp_url", "pic_url", "subWord", "type", "group_mask"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, DynamicAssociationWord$AssociationItem.class);
    }

    public DynamicAssociationWord$AssociationItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.subWord = PBField.initBytes(byteStringMicro);
        this.type = PBField.initUInt32(0);
        this.group_mask = PBField.initUInt32(0);
    }
}
