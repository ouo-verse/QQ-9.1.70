package zj2;

import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.tavcut.render.player.IPlayer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lzj2/f;", "Lzj2/d;", "", "eventX", "eventY", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "o8", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int da(VideoStickerModel videoStickerModel, VideoStickerModel videoStickerModel2) {
        int i3;
        int i16 = 0;
        if (videoStickerModel2 != null) {
            i3 = videoStickerModel2.layerIndex;
        } else {
            i3 = 0;
        }
        if (videoStickerModel != null) {
            i16 = videoStickerModel.layerIndex;
        }
        return i3 - i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r9, new zj2.e());
     */
    @Override // zj2.d, com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoStickerModel o8(float eventX, float eventY) {
        long j3;
        List sortedWith;
        Object firstOrNull;
        aw F9 = F9();
        if (F9 == null) {
            return null;
        }
        IPlayer player = F9.getPlayer();
        if (player != null) {
            j3 = player.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        Map<String, VideoStickerModel> m3 = F9.m();
        if (m3 == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, VideoStickerModel> entry : m3.entrySet()) {
            if (entry.getValue().isClickInsideV2(eventX, eventY, F9)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((VideoStickerModel) entry2.getValue()).isVisibleAtCurrentPlayTime(j3)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        Collection values = linkedHashMap2.values();
        if (values != null && sortedWith != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
            return (VideoStickerModel) firstOrNull;
        }
        return null;
    }
}
