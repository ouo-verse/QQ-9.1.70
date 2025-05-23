package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicBusinessHotWord$GroupWord extends MessageMicro<DynamicBusinessHotWord$GroupWord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"group_id", "rpt_hot_word_items", "clue_word_item"}, new Object[]{null, null, null}, DynamicBusinessHotWord$GroupWord.class);
    public DynamicBusinessHotWord$GroupID group_id = new MessageMicro<DynamicBusinessHotWord$GroupID>() { // from class: tencent.im.oidb.search.DynamicBusinessHotWord$GroupID
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_group_mask"}, new Object[]{0L}, DynamicBusinessHotWord$GroupID.class);
        public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public final PBRepeatMessageField<DynamicBusinessHotWord$HotWordItem> rpt_hot_word_items = PBField.initRepeatMessage(DynamicBusinessHotWord$HotWordItem.class);
    public DynamicBusinessHotWord$ClueWordItem clue_word_item = new MessageMicro<DynamicBusinessHotWord$ClueWordItem>() { // from class: tencent.im.oidb.search.DynamicBusinessHotWord$ClueWordItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField word;
        public final PBBytesField word_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"word_id", "word"}, new Object[]{byteStringMicro, byteStringMicro}, DynamicBusinessHotWord$ClueWordItem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.word_id = PBField.initBytes(byteStringMicro);
            this.word = PBField.initBytes(byteStringMicro);
        }
    };
}
