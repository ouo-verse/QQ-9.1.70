package unite;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class DynamicSearch$ResultItemGroup extends MessageMicro<DynamicSearch$ResultItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_footer_jump_url;
    public final PBBytesField group_footer_name;
    public final PBUInt64Field group_mask = PBField.initUInt64(0);
    public final PBBytesField group_name;
    public final PBUInt32Field hide_title;
    public final PBUInt32Field hide_title_blank_view;
    public final PBUInt32Field highlight_title_keyword;
    public final PBBytesField more_name;
    public final PBBytesField more_url;
    public final PBRepeatMessageField<DynamicSearch$ResultItem> result_items;
    public final PBRepeatField<ByteStringMicro> rpt_highlight_words;
    public final PBUInt64Field total_result_count;

    static {
        String[] strArr = {"group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", IPCConst.KEY_HIDE_TITLE, "highlight_title_keyword", "hide_title_blank_view", "group_footer_name", "group_footer_jump_url", "rpt_highlight_words"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 64, 72, 82, 90, 8002}, strArr, new Object[]{0L, byteStringMicro, null, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, DynamicSearch$ResultItemGroup.class);
    }

    public DynamicSearch$ResultItemGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.result_items = PBField.initRepeatMessage(DynamicSearch$ResultItem.class);
        this.total_result_count = PBField.initUInt64(0L);
        this.more_url = PBField.initBytes(byteStringMicro);
        this.more_name = PBField.initBytes(byteStringMicro);
        this.hide_title = PBField.initUInt32(0);
        this.highlight_title_keyword = PBField.initUInt32(0);
        this.hide_title_blank_view = PBField.initUInt32(0);
        this.group_footer_name = PBField.initBytes(byteStringMicro);
        this.group_footer_jump_url = PBField.initBytes(byteStringMicro);
        this.rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
    }
}
