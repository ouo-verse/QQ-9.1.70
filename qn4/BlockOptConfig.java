package qn4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lqn4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "gameRoomFetchOperationAds", "Z", "b", "()Z", "gameRoomFetchOperationAdsInSubThread", "c", "gameRoomNoLoadTabWhenPageOut", "getGameRoomNoLoadTabWhenPageOut", "gameRoomNoEnterRoomWhenPageOut", "getGameRoomNoEnterRoomWhenPageOut", "forceDestroyRoom", "a", "<init>", "(ZZZZZ)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qn4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BlockOptConfig {

    @SerializedName("force_destroy_room")
    private final boolean forceDestroyRoom;

    @SerializedName("game_room_fetch_operation_ads")
    private final boolean gameRoomFetchOperationAds;

    @SerializedName("game_room_fetch_operation_ads_in_sub_thread")
    private final boolean gameRoomFetchOperationAdsInSubThread;

    @SerializedName("game_room_no_enter_room_when_page_out")
    private final boolean gameRoomNoEnterRoomWhenPageOut;

    @SerializedName("game_room_no_load_tab_when_page_out")
    private final boolean gameRoomNoLoadTabWhenPageOut;

    public BlockOptConfig() {
        this(false, false, false, false, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getForceDestroyRoom() {
        return this.forceDestroyRoom;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getGameRoomFetchOperationAds() {
        return this.gameRoomFetchOperationAds;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getGameRoomFetchOperationAdsInSubThread() {
        return this.gameRoomFetchOperationAdsInSubThread;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockOptConfig)) {
            return false;
        }
        BlockOptConfig blockOptConfig = (BlockOptConfig) other;
        if (this.gameRoomFetchOperationAds == blockOptConfig.gameRoomFetchOperationAds && this.gameRoomFetchOperationAdsInSubThread == blockOptConfig.gameRoomFetchOperationAdsInSubThread && this.gameRoomNoLoadTabWhenPageOut == blockOptConfig.gameRoomNoLoadTabWhenPageOut && this.gameRoomNoEnterRoomWhenPageOut == blockOptConfig.gameRoomNoEnterRoomWhenPageOut && this.forceDestroyRoom == blockOptConfig.forceDestroyRoom) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.gameRoomFetchOperationAds;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.gameRoomFetchOperationAdsInSubThread;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.gameRoomNoLoadTabWhenPageOut;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ?? r28 = this.gameRoomNoEnterRoomWhenPageOut;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z17 = this.forceDestroyRoom;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i28 + i3;
    }

    @NotNull
    public String toString() {
        return "BlockOptConfig(gameRoomFetchOperationAds=" + this.gameRoomFetchOperationAds + ", gameRoomFetchOperationAdsInSubThread=" + this.gameRoomFetchOperationAdsInSubThread + ", gameRoomNoLoadTabWhenPageOut=" + this.gameRoomNoLoadTabWhenPageOut + ", gameRoomNoEnterRoomWhenPageOut=" + this.gameRoomNoEnterRoomWhenPageOut + ", forceDestroyRoom=" + this.forceDestroyRoom + ')';
    }

    public BlockOptConfig(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        this.gameRoomFetchOperationAds = z16;
        this.gameRoomFetchOperationAdsInSubThread = z17;
        this.gameRoomNoLoadTabWhenPageOut = z18;
        this.gameRoomNoEnterRoomWhenPageOut = z19;
        this.forceDestroyRoom = z26;
    }

    public /* synthetic */ BlockOptConfig(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? true : z18, (i3 & 8) != 0 ? true : z19, (i3 & 16) != 0 ? true : z26);
    }
}
