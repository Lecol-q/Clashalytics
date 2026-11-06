import "./NavBar.css";
import { useState } from "react";

function Navbar({tag, setTag, searchPlayerDashboard, setIsSidebarOpen}) {
    const [isSearchOpen, setIsSearchOpen] = useState(false);

    return (
        <header className="toolBar">
            <button
                className="brand"
                onClick={() => window.location.href = "/"}
                aria-label="Homepage"
            >
                <svg
                    viewBox="0 0 24 24"
                    width="28"
                    height="28"
                    fill="none"
                    stroke="#f6c85f"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                >
                    <path d="m2 7 5 5 5-8 5 8 5-5-2 13H4L2 7Z"/>
                </svg>
                <span>Clashalytics</span>
            </button>

            <nav className="navActions">
                <div className={`searchBox ${isSearchOpen ? "expanded" : ""}`}>
                    <input
                        type="text"
                        placeholder="#PlayerTag"
                        aria-label="Player tag"
                        value={tag}
                        onChange={e => setTag(e.target.value)}
                    />

                    {/* This is the main toolbar*/}
                    <button
                        className="searchButton"
                        onClick={() => {
                            if (!isSearchOpen) {
                                setIsSearchOpen(true);
                            } else {
                                searchPlayerDashboard();
                            }
                        }}
                        aria-label="Search player"
                    >
                        <svg
                            viewBox="0 0 24 24"
                            width="20"
                            height="20"
                            fill="none"
                            stroke="currentColor"
                            strokeWidth="2"
                            strokeLinecap="round"
                            strokeLinejoin="round"
                        >
                            <circle cx="11" cy="11" r="7"/>
                            <path d="m16 16 4 4"/>
                        </svg>
                    </button>
                </div>

                <button
                    className="userButton"
                    onClick={() => setIsSidebarOpen(true)}
                    aria-label="Login"
                    title="Login"
                >
                    <button
                        className="userButton"
                        onClick={() => setIsSidebarOpen(true)}
                        aria-label="Login"
                        title="Login"
                    >
                        <svg
                            viewBox="0 0 24 24"
                            width="26"
                            height="26"
                            fill="none"
                            stroke="currentColor"
                            strokeWidth="1.8"
                            strokeLinecap="round"
                            strokeLinejoin="round"
                        >
                            <circle cx="12" cy="8" r="4" />
                            <path d="M5 21v-2a7 7 0 0 1 14 0v2" />
                        </svg>
                    </button>
                </button>
            </nav>
        </header>
    );
}

export default Navbar;