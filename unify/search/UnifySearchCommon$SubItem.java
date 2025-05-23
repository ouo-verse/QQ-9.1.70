package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$SubItem extends MessageMicro<UnifySearchCommon$SubItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField backgroud_color;
    public final PBBytesField jump_url;
    public final PBUInt32Field show_arrow;
    public final PBUInt32Field layout_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon$SubItemText> title = PBField.initRepeatMessage(UnifySearchCommon$SubItemText.class);
    public final PBRepeatMessageField<UnifySearchCommon$SubItemText> summary = PBField.initRepeatMessage(UnifySearchCommon$SubItemText.class);
    public final PBUInt32Field media_total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon$SubItemMedia> media_list = PBField.initRepeatMessage(UnifySearchCommon$SubItemMedia.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 66}, new String[]{"layout_id", "title", "summary", "media_total_count", "media_list", "jump_url", "show_arrow", "backgroud_color"}, new Object[]{0, null, null, 0, null, byteStringMicro, 0, byteStringMicro}, UnifySearchCommon$SubItem.class);
    }

    public UnifySearchCommon$SubItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.show_arrow = PBField.initUInt32(0);
        this.backgroud_color = PBField.initBytes(byteStringMicro);
    }
}
