package unify.search;

import com.tencent.mobileqq.app.AppConstants;
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
public final class UnifySearchCommon$ResultItemGroup extends MessageMicro<UnifySearchCommon$ResultItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_extra_flag;
    public final PBBytesField group_footer_jump_url;
    public final PBBytesField group_footer_name;
    public final PBUInt64Field group_mask = PBField.initUInt64(0);
    public final PBBytesField group_name;
    public final PBUInt32Field hide_title;
    public final PBUInt32Field hide_title_blank_view;
    public final PBUInt32Field highlight_title_keyword;
    public final PBUInt32Field is_big_pic;
    public final PBUInt32Field is_end;
    public final PBBytesField layout_name;
    public final PBBytesField more_name;
    public final PBBytesField more_url;
    public final PBRepeatMessageField<UnifySearchCommon$ResultItem> result_items;
    public final PBRepeatField<ByteStringMicro> rpt_highlight_words;
    public final PBBytesField session_info;
    public final PBUInt64Field total_result_count;

    static {
        String[] strArr = {"group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", IPCConst.KEY_HIDE_TITLE, "highlight_title_keyword", "hide_title_blank_view", "group_footer_name", "group_footer_jump_url", "group_extra_flag", "is_end", AppConstants.Key.SESSION_INFO, "layout_name", "rpt_highlight_words", "is_big_pic"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 64, 72, 82, 90, 96, 104, 114, 810, 8002, 8080}, strArr, new Object[]{0L, byteStringMicro, null, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0}, UnifySearchCommon$ResultItemGroup.class);
    }

    public UnifySearchCommon$ResultItemGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.result_items = PBField.initRepeatMessage(UnifySearchCommon$ResultItem.class);
        this.total_result_count = PBField.initUInt64(0L);
        this.more_url = PBField.initBytes(byteStringMicro);
        this.more_name = PBField.initBytes(byteStringMicro);
        this.hide_title = PBField.initUInt32(0);
        this.highlight_title_keyword = PBField.initUInt32(0);
        this.hide_title_blank_view = PBField.initUInt32(0);
        this.group_footer_name = PBField.initBytes(byteStringMicro);
        this.group_footer_jump_url = PBField.initBytes(byteStringMicro);
        this.group_extra_flag = PBField.initUInt32(0);
        this.is_end = PBField.initUInt32(0);
        this.session_info = PBField.initBytes(byteStringMicro);
        this.layout_name = PBField.initBytes(byteStringMicro);
        this.rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.is_big_pic = PBField.initUInt32(0);
    }
}
